package org.msee.slmtoolbox.modeling.model.ssm.tim.dialogs;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.swt.widgets.Shell;
import org.msee.slmtoolbox.modeling.model.ssm.tim.CommonConcepts.TimProcess;
import org.msee.slmtoolbox.modeling.model.ssm.tim.CommonConcepts.TimResource;

/**
 * 
 * @author HBA6
 * this is the dialog to add resources to a process
 *
 */
public class TimAddProcessToResourceDialog extends AbstractTimElementDialog<TimResource, TimProcess> {
	
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
	 *            process
	 * @param labelProvider
	 *            labelProvider
	 * 
	 */
	public TimAddProcessToResourceDialog(Shell parentShell, ILabelProvider labelProvider,
			TimResource elementBeCompleted) {
		super(parentShell, labelProvider, elementBeCompleted, "String Selection", "Select a String (* = any string, ? = any char):", TimProcess.class);
	}

	@Override
	protected List<TimProcess> getListSource() {
		List<TimProcess> listSource = new ArrayList<TimProcess>();
		if(null != getElementBeCompleted()) {
			listSource.addAll(getElementBeCompleted().getModel().getProcesses());
		}
		return listSource;
	}

	@Override
	protected List<TimProcess> getListFiltre() {
		List<TimProcess> listFilter = new ArrayList<TimProcess>();
		if(null != getElementBeCompleted()) {
			listFilter.addAll(getElementBeCompleted().getProcesses());
		}
		return listFilter;
	}

	@Override
	protected void addNewElementToElementTarget(TimProcess newElement) {
		newElement.getResources().add(getElementBeCompleted());
		getElementBeCompleted().getProcesses().add(newElement);
	}
}
