package org.msee.slmtoolbox.modeling.model.ssm.tim.dialogs;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.swt.widgets.Shell;
import org.msee.slmtoolbox.modeling.model.ssm.tim.CommonConcepts.TimProcess;

/**
 * 
 * @author HBA6
 * this is the dialog to add resources to a process
 *
 */
public class TimAddProcessToProcessDialog extends AbstractTimElementDialog<TimProcess, TimProcess> {
	
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
	public TimAddProcessToProcessDialog(Shell parentShell, ILabelProvider labelProvider,
			TimProcess elementBeCompleted) {
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
			listFilter.addAll(getElementBeCompleted().getSubprocesses());
			listFilter.add(getElementBeCompleted());
		}
		return listFilter;
	}

	@Override
	protected void addNewElementToElementTarget(TimProcess newElement) {
		newElement.setMainProcess(getElementBeCompleted());
		getElementBeCompleted().getSubprocesses().add(newElement);
	}
}
