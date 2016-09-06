/*
 * Copyright 2010 JBoss Inc
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.jbpm.eclipse.wizard.project;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.core.resources.ICommand;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceStatus;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.jdt.core.IClasspathContainer;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.ui.PreferenceConstants;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.ui.dialogs.WizardNewProjectCreationPage;
import org.eclipse.ui.wizards.newresource.BasicNewResourceWizard;
import org.jbpm.eclipse.JBPMEclipsePlugin;
import org.jbpm.eclipse.util.JBPMClasspathContainer;

/**
 * A wizard to create a new jBPM project.
 * 
 * @author <a href="mailto:kris_verlaenen@hotmail.com">kris verlaenen </a>
 */
public class NewJBPMMavenProjectWizard extends BasicNewResourceWizard {

    public static final String JUNIT_CLASSPATH_CONTAINER_PATH = "org.eclipse.jdt.junit.JUNIT_CONTAINER/4";
    
    private IProject newProject;
    private WizardNewProjectCreationPage mainPage;
    
    public void addPages() {
        super.addPages();
        mainPage = new WizardNewProjectCreationPage("basicNewProjectPage");
        mainPage.setTitle("New jBPM Maven Project");
        mainPage.setDescription("Create a new jBPM Maven Project");
        this.addPage(mainPage);
        setNeedsProgressMonitor(true);
    }

    public boolean performFinish() {
        createJBPMProject();
        if (newProject == null) {
            return false;
        }
        selectAndReveal(newProject);
        return true;
    }

    private void createJBPMProject() {
        newProject = createNewProject();
        WorkspaceModifyOperation op = new WorkspaceModifyOperation() {
            protected void execute(IProgressMonitor monitor)
                    throws CoreException {
                try {
                	IJavaProject project = JavaCore.create(newProject);
                    createOutputLocation(project, monitor);
                    addJavaBuilder(project, monitor);
                    setClasspath(project, monitor);
                    createInitialContent(project, monitor);
                	newProject.build(IncrementalProjectBuilder.FULL_BUILD, monitor);
                } catch (IOException _ex) {
                	ErrorDialog.openError(getShell(), "Problem creating jBPM Maven project",
                        null, null);
                }
            }
        };
        try {
            getContainer().run(true, true, op);
        } catch (Throwable t) {
            JBPMEclipsePlugin.log(t);
        }
    }
    
    private IProject createNewProject() {
        if (newProject != null) {
            return newProject;
        }
        final IProject newProjectHandle = mainPage.getProjectHandle();

        // get a project descriptor
        IPath newPath = null;
        if (!mainPage.useDefaults())
            newPath = mainPage.getLocationPath();

        IWorkspace workspace = ResourcesPlugin.getWorkspace();
        final IProjectDescription description = workspace
                .newProjectDescription(newProjectHandle.getName());
        description.setLocation(newPath);
        addNatures(description);

        // create the new project operation
        WorkspaceModifyOperation op = new WorkspaceModifyOperation() {
            protected void execute(IProgressMonitor monitor)
                    throws CoreException {
                createProject(description, newProjectHandle, monitor);
            }
        };

        // run the new project creation operation
        try {
            getContainer().run(true, true, op);
        } catch (InterruptedException e) {
            return null;
        } catch (InvocationTargetException e) {
            Throwable t = e.getTargetException();
            if (t instanceof CoreException) {
                if (((CoreException) t).getStatus().getCode() == IResourceStatus.CASE_VARIANT_EXISTS) {
                    MessageDialog.openError(getShell(),
                        "NewProject.errorMessage",
                        "NewProject.caseVariantExistsError"
                                + newProjectHandle.getName());
                } else {
                    ErrorDialog.openError(getShell(),
                        "NewProject.errorMessage", null, // no special message
                        ((CoreException) t).getStatus());
                }
            } else {
                JBPMEclipsePlugin.log(e);
            }
            return null;
        }

        return newProjectHandle;
    }
    
    private void addNatures(IProjectDescription projectDescription) {
        List list = new ArrayList();
        list.addAll(Arrays.asList(projectDescription.getNatureIds()));
        list.add("org.eclipse.jdt.core.javanature");
        list.add("org.eclipse.m2e.core.maven2Nature");
        projectDescription.setNatureIds((String[]) list
            .toArray(new String[list.size()]));
    }
    
    private void createProject(IProjectDescription description,
            IProject projectHandle, IProgressMonitor monitor)
            throws CoreException, OperationCanceledException {
        try {
            monitor.beginTask("", 2000);
            projectHandle.create(description, new SubProgressMonitor(monitor,
                    1000));
            if (monitor.isCanceled()) {
                throw new OperationCanceledException();
            }
            projectHandle.open(IResource.BACKGROUND_REFRESH,
                new SubProgressMonitor(monitor, 1000));
        } finally {
            monitor.done();
        }
    }
    
    private void createOutputLocation(IJavaProject project, IProgressMonitor monitor)
            throws JavaModelException, CoreException {
        IFolder folder = project.getProject().getFolder("target/classes");
        createFolder(folder, monitor);
        IPath path = folder.getFullPath();
        project.setOutputLocation(path, null);
    }

    private void addJavaBuilder(IJavaProject project, IProgressMonitor monitor) throws CoreException {
        IProjectDescription description = project.getProject().getDescription();
        ICommand[] commands = description.getBuildSpec();
        ICommand[] newCommands = new ICommand[commands.length + 2];
        System.arraycopy(commands, 0, newCommands, 0, commands.length);

        ICommand javaCommand = description.newCommand();
        javaCommand.setBuilderName("org.eclipse.jdt.core.javabuilder");
        newCommands[commands.length] = javaCommand;
        
        ICommand mavenCommand = description.newCommand();
        mavenCommand.setBuilderName("org.eclipse.m2e.core.maven2Builder");
        newCommands[commands.length + 1] = mavenCommand;
        
        description.setBuildSpec(newCommands);
        project.getProject().setDescription(description, monitor);
    }

    private void setClasspath(IJavaProject project, IProgressMonitor monitor)
            throws JavaModelException, CoreException {
        project.setRawClasspath(new IClasspathEntry[0], monitor);
        addSourceFolders(project, monitor);
        addJRELibraries(project, monitor);
    	addJUnitLibrary(project, monitor);
    	addMavenClasspathContainer(project, monitor);
    }

    private void addSourceFolders(IJavaProject project, IProgressMonitor monitor) throws JavaModelException, CoreException {
        List list = new ArrayList();
        list.addAll(Arrays.asList(project.getRawClasspath()));
        addSourceFolder(project, list, "src/main/java", monitor);
        addSourceFolder(project, list, "src/main/resources", monitor);
        project.setRawClasspath((IClasspathEntry[]) list.toArray(new IClasspathEntry[list.size()]), null);
    }
    
    private void addJRELibraries(IJavaProject project, IProgressMonitor monitor) throws JavaModelException {
        List list = new ArrayList();
        list.addAll(Arrays.asList(project.getRawClasspath()));
        list.addAll(Arrays.asList(PreferenceConstants.getDefaultJRELibrary()));
        project.setRawClasspath((IClasspathEntry[]) list
            .toArray(new IClasspathEntry[list.size()]), monitor);
    }

    private static IPath getJUnitClassPathContainerPath() {
        return new Path(JUNIT_CLASSPATH_CONTAINER_PATH);
    }

    public static void addJUnitLibrary(IJavaProject project, IProgressMonitor monitor)
    		throws JavaModelException {
		List list = new ArrayList();
		list.addAll(Arrays.asList(project.getRawClasspath()));
		list.add(JavaCore.newContainerEntry(getJUnitClassPathContainerPath()));
		project.setRawClasspath((IClasspathEntry[]) list
		    .toArray(new IClasspathEntry[list.size()]), monitor);
    }

    public static void addMavenClasspathContainer(IJavaProject project, IProgressMonitor monitor)
    		throws JavaModelException {
		List list = new ArrayList();
		list.addAll(Arrays.asList(project.getRawClasspath()));
		list.add(JavaCore.newContainerEntry(getMavenClassPathContainerPath()));
		project.setRawClasspath((IClasspathEntry[]) list
		    .toArray(new IClasspathEntry[list.size()]), monitor);
    }

    private static IPath getMavenClassPathContainerPath() {
        return new Path("org.eclipse.m2e.MAVEN2_CLASSPATH_CONTAINER");
    }

    private void createInitialContent(IJavaProject project, IProgressMonitor monitor)
            throws CoreException, JavaModelException, IOException {
    	try {
    		createProcess(project, monitor);
    		createProcessSampleMain(project, monitor);
    		createKModuleXML(project, monitor);
    		createPOM(project, monitor);
    	} catch (Throwable t) {
    		t.printStackTrace();
    	}
	}

    /**
     * Create the sample process file.
     */
    private void createProcess(IJavaProject project, IProgressMonitor monitor) throws CoreException {
	    String fileName = "org/jbpm/eclipse/wizard/project/advanced.bpmn.template";
        IFolder folder = project.getProject().getFolder("src/main/resources/com/sample");
        createFolder(folder, monitor);
        IFile file = folder.getFile("sample.bpmn");
        InputStream inputstream = getClass().getClassLoader().getResourceAsStream(fileName);
        if (!file.exists()) {
            file.create(inputstream, true, monitor);
        } else {
            file.setContents(inputstream, true, false, monitor);
        }
    }

    /**
     * Create the kmodule.xml file.
     */
    private void createKModuleXML(IJavaProject project, IProgressMonitor monitor) throws CoreException {
	    String fileName = "org/jbpm/eclipse/wizard/project/kmodule.xml.template";
        IFolder folder = project.getProject().getFolder("src/main/resources/META-INF");
        createFolder(folder, monitor);
        IFile file = folder.getFile("kmodule.xml");
        InputStream inputstream = getClass().getClassLoader().getResourceAsStream(fileName);
        if (!file.exists()) {
            file.create(inputstream, true, monitor);
        } else {
            file.setContents(inputstream, true, false, monitor);
        }
    }

    /**
     * Create the kmodule.xml file.
     */
    private void createPOM(IJavaProject project, IProgressMonitor monitor) throws CoreException {
	    String fileName = "org/jbpm/eclipse/wizard/project/maven-pom.xml.template";
        IFile file = project.getProject().getFile("pom.xml");
        InputStream inputstream = getClass().getClassLoader().getResourceAsStream(fileName);
        if (!file.exists()) {
            file.create(inputstream, true, monitor);
        } else {
            file.setContents(inputstream, true, false, monitor);
        }
    }

    /**
     * Create the sample process junit test file.
     */
    private void createProcessSampleMain(IJavaProject project, IProgressMonitor monitor)
            throws JavaModelException, IOException {
    	String s = "org/jbpm/eclipse/wizard/project/ProcessMain-advanced.java.template";
        IFolder folder = project.getProject().getFolder("src/main/java");
        IPackageFragmentRoot packageFragmentRoot = project
                .getPackageFragmentRoot(folder);
        IPackageFragment packageFragment = packageFragmentRoot
                .createPackageFragment("com.sample", true, monitor);
        InputStream inputstream = getClass().getClassLoader()
                .getResourceAsStream(s);
        packageFragment.createCompilationUnit("ProcessMain.java", new String(
                readStream(inputstream)), true, monitor);
    }

    private byte[] readStream(InputStream inputstream) throws IOException {
		byte bytes[] = (byte[]) null;
		int i = 0;
		byte tempBytes[] = new byte[1024];
		for (int j = inputstream.read(tempBytes); j != -1; j = inputstream.read(tempBytes)) {
			byte tempBytes2[] = new byte[i + j];
			if (i > 0) {
				System.arraycopy(bytes, 0, tempBytes2, 0, i);
			}
			System.arraycopy(tempBytes, 0, tempBytes2, i, j);
			bytes = tempBytes2;
			i += j;
		}

		return bytes;
	}
    
    private void addSourceFolder(IJavaProject project, List list, String s, IProgressMonitor monitor) throws CoreException {
        IFolder folder = project.getProject().getFolder(s);
        createFolder(folder, monitor);
        IPackageFragmentRoot ipackagefragmentroot = project.getPackageFragmentRoot(folder);
        list.add(JavaCore.newSourceEntry(ipackagefragmentroot.getPath()));
    }
    
    private void createFolder(IFolder folder, IProgressMonitor monitor) throws CoreException {
        IContainer container = folder.getParent();
        if (container != null && !container.exists()
                && (container instanceof IFolder))
            createFolder((IFolder) container, monitor);
        if (!folder.exists()) {
        	folder.create(true, true, monitor);
        }
    }
}
