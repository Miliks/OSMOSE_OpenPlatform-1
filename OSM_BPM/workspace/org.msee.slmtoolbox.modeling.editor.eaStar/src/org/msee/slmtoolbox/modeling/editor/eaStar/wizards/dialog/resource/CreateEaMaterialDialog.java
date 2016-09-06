package org.msee.slmtoolbox.modeling.editor.eaStar.wizards.dialog.resource;

import org.eclipse.swt.widgets.Shell;
import org.msee.slmtoolbox.modeling.editor.eaStar.util.PropertiesEAStar.EAStarEditorWizardProperties;
import org.msee.slmtoolbox.modeling.model.lang.eaStar.coreElements.EaMaterialResource;
import org.msee.slmtoolbox.modeling.model.lang.eaStar.coreElements.EaOrganization;
import org.msee.slmtoolbox.modeling.model.lang.eaStar.generalElements.EaProcess;
import org.msee.slmtoolbox.modeling.service.app.lang.eastar.EAStarAppService;

/**
 * Dialog for create a material EAStarResource 
 * @author fto
 *
 */
public class CreateEaMaterialDialog extends AbstractCreateEaResourceDialog<EaMaterialResource> {
	
	 /**
     * Creates an input dialog with OK and Cancel buttons. Note that the dialog
     * will have no visual representation (no widgets) until it is told to open.
     * <p>
     * Note that the <code>open</code> method blocks for input dialogs.
     * </p>
     * 
     * @param parentShell
     *            the parent shell, or <code>null</code> to create a top-level
     *            shell
     * @param process 
     * 				process
     * @param service
     * 				AppService
     */
    public CreateEaMaterialDialog(Shell parentShell, EaProcess process,EAStarAppService service, EaOrganization eaOrganization) {
        super(parentShell, process, EaMaterialResource.class, service, EAStarEditorWizardProperties.RESOURCE_MATERIAL_TITLE, eaOrganization);
        setErrorMessage(EAStarEditorWizardProperties.RESOURCE_MATERIAL_ERROR);
        setUserQuestionName(EAStarEditorWizardProperties.RESOURCE_MATERIAL_QUESTION);
    }

}