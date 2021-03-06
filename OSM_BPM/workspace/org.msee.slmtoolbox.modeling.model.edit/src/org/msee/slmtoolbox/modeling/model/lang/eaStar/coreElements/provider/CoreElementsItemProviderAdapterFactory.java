/**
 */
package org.msee.slmtoolbox.modeling.model.lang.eaStar.coreElements.provider;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.edit.provider.ChangeNotifier;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IChangeNotifier;
import org.eclipse.emf.edit.provider.IDisposable;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.INotifyChangedListener;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;

import org.msee.slmtoolbox.modeling.model.lang.eaStar.coreElements.util.CoreElementsAdapterFactory;

/**
 * This is the factory that is used to provide the interfaces needed to support Viewers.
 * The adapters generated by this factory convert EMF adapter notifications into calls to {@link #fireNotifyChanged fireNotifyChanged}.
 * The adapters also support Eclipse property sheets.
 * Note that most of the adapters are shared among multiple instances.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class CoreElementsItemProviderAdapterFactory extends CoreElementsAdapterFactory implements ComposeableAdapterFactory, IChangeNotifier, IDisposable {
	/**
	 * This keeps track of the root adapter factory that delegates to this adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComposedAdapterFactory parentAdapterFactory;

	/**
	 * This is used to implement {@link org.eclipse.emf.edit.provider.IChangeNotifier}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IChangeNotifier changeNotifier = new ChangeNotifier();

	/**
	 * This keeps track of all the supported types checked by {@link #isFactoryForType isFactoryForType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Collection<Object> supportedTypes = new ArrayList<Object>();

	/**
	 * This constructs an instance.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CoreElementsItemProviderAdapterFactory() {
		supportedTypes.add(IEditingDomainItemProvider.class);
		supportedTypes.add(IStructuredItemContentProvider.class);
		supportedTypes.add(ITreeItemContentProvider.class);
		supportedTypes.add(IItemLabelProvider.class);
		supportedTypes.add(IItemPropertySource.class);
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.msee.slmtoolbox.modeling.model.lang.eaStar.coreElements.EaITResource} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EaITResourceItemProvider eaITResourceItemProvider;

	/**
	 * This creates an adapter for a {@link org.msee.slmtoolbox.modeling.model.lang.eaStar.coreElements.EaITResource}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createEaITResourceAdapter() {
		if (eaITResourceItemProvider == null) {
			eaITResourceItemProvider = new EaITResourceItemProvider(this);
		}

		return eaITResourceItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.msee.slmtoolbox.modeling.model.lang.eaStar.coreElements.EaHumanResource} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EaHumanResourceItemProvider eaHumanResourceItemProvider;

	/**
	 * This creates an adapter for a {@link org.msee.slmtoolbox.modeling.model.lang.eaStar.coreElements.EaHumanResource}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createEaHumanResourceAdapter() {
		if (eaHumanResourceItemProvider == null) {
			eaHumanResourceItemProvider = new EaHumanResourceItemProvider(this);
		}

		return eaHumanResourceItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.msee.slmtoolbox.modeling.model.lang.eaStar.coreElements.EaMaterialResource} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EaMaterialResourceItemProvider eaMaterialResourceItemProvider;

	/**
	 * This creates an adapter for a {@link org.msee.slmtoolbox.modeling.model.lang.eaStar.coreElements.EaMaterialResource}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createEaMaterialResourceAdapter() {
		if (eaMaterialResourceItemProvider == null) {
			eaMaterialResourceItemProvider = new EaMaterialResourceItemProvider(this);
		}

		return eaMaterialResourceItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.msee.slmtoolbox.modeling.model.lang.eaStar.coreElements.EaOr} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EaOrItemProvider eaOrItemProvider;

	/**
	 * This creates an adapter for a {@link org.msee.slmtoolbox.modeling.model.lang.eaStar.coreElements.EaOr}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createEaOrAdapter() {
		if (eaOrItemProvider == null) {
			eaOrItemProvider = new EaOrItemProvider(this);
		}

		return eaOrItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.msee.slmtoolbox.modeling.model.lang.eaStar.coreElements.EaAnd} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EaAndItemProvider eaAndItemProvider;

	/**
	 * This creates an adapter for a {@link org.msee.slmtoolbox.modeling.model.lang.eaStar.coreElements.EaAnd}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createEaAndAdapter() {
		if (eaAndItemProvider == null) {
			eaAndItemProvider = new EaAndItemProvider(this);
		}

		return eaAndItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.msee.slmtoolbox.modeling.model.lang.eaStar.coreElements.EaDivergingAnd} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EaDivergingAndItemProvider eaDivergingAndItemProvider;

	/**
	 * This creates an adapter for a {@link org.msee.slmtoolbox.modeling.model.lang.eaStar.coreElements.EaDivergingAnd}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createEaDivergingAndAdapter() {
		if (eaDivergingAndItemProvider == null) {
			eaDivergingAndItemProvider = new EaDivergingAndItemProvider(this);
		}

		return eaDivergingAndItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.msee.slmtoolbox.modeling.model.lang.eaStar.coreElements.EaDivergingOr} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EaDivergingOrItemProvider eaDivergingOrItemProvider;

	/**
	 * This creates an adapter for a {@link org.msee.slmtoolbox.modeling.model.lang.eaStar.coreElements.EaDivergingOr}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createEaDivergingOrAdapter() {
		if (eaDivergingOrItemProvider == null) {
			eaDivergingOrItemProvider = new EaDivergingOrItemProvider(this);
		}

		return eaDivergingOrItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.msee.slmtoolbox.modeling.model.lang.eaStar.coreElements.EaConvergingAnd} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EaConvergingAndItemProvider eaConvergingAndItemProvider;

	/**
	 * This creates an adapter for a {@link org.msee.slmtoolbox.modeling.model.lang.eaStar.coreElements.EaConvergingAnd}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createEaConvergingAndAdapter() {
		if (eaConvergingAndItemProvider == null) {
			eaConvergingAndItemProvider = new EaConvergingAndItemProvider(this);
		}

		return eaConvergingAndItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.msee.slmtoolbox.modeling.model.lang.eaStar.coreElements.EaConvergingOr} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EaConvergingOrItemProvider eaConvergingOrItemProvider;

	/**
	 * This creates an adapter for a {@link org.msee.slmtoolbox.modeling.model.lang.eaStar.coreElements.EaConvergingOr}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createEaConvergingOrAdapter() {
		if (eaConvergingOrItemProvider == null) {
			eaConvergingOrItemProvider = new EaConvergingOrItemProvider(this);
		}

		return eaConvergingOrItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.msee.slmtoolbox.modeling.model.lang.eaStar.coreElements.EaInternalConnector} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EaInternalConnectorItemProvider eaInternalConnectorItemProvider;

	/**
	 * This creates an adapter for a {@link org.msee.slmtoolbox.modeling.model.lang.eaStar.coreElements.EaInternalConnector}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createEaInternalConnectorAdapter() {
		if (eaInternalConnectorItemProvider == null) {
			eaInternalConnectorItemProvider = new EaInternalConnectorItemProvider(this);
		}

		return eaInternalConnectorItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.msee.slmtoolbox.modeling.model.lang.eaStar.coreElements.EaExternalConnector} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EaExternalConnectorItemProvider eaExternalConnectorItemProvider;

	/**
	 * This creates an adapter for a {@link org.msee.slmtoolbox.modeling.model.lang.eaStar.coreElements.EaExternalConnector}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createEaExternalConnectorAdapter() {
		if (eaExternalConnectorItemProvider == null) {
			eaExternalConnectorItemProvider = new EaExternalConnectorItemProvider(this);
		}

		return eaExternalConnectorItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.msee.slmtoolbox.modeling.model.lang.eaStar.coreElements.EaProcessConnector} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EaProcessConnectorItemProvider eaProcessConnectorItemProvider;

	/**
	 * This creates an adapter for a {@link org.msee.slmtoolbox.modeling.model.lang.eaStar.coreElements.EaProcessConnector}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createEaProcessConnectorAdapter() {
		if (eaProcessConnectorItemProvider == null) {
			eaProcessConnectorItemProvider = new EaProcessConnectorItemProvider(this);
		}

		return eaProcessConnectorItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.msee.slmtoolbox.modeling.model.lang.eaStar.coreElements.EaOutputInputFlow} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EaOutputInputFlowItemProvider eaOutputInputFlowItemProvider;

	/**
	 * This creates an adapter for a {@link org.msee.slmtoolbox.modeling.model.lang.eaStar.coreElements.EaOutputInputFlow}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createEaOutputInputFlowAdapter() {
		if (eaOutputInputFlowItemProvider == null) {
			eaOutputInputFlowItemProvider = new EaOutputInputFlowItemProvider(this);
		}

		return eaOutputInputFlowItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.msee.slmtoolbox.modeling.model.lang.eaStar.coreElements.EaSupportFlow} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EaSupportFlowItemProvider eaSupportFlowItemProvider;

	/**
	 * This creates an adapter for a {@link org.msee.slmtoolbox.modeling.model.lang.eaStar.coreElements.EaSupportFlow}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createEaSupportFlowAdapter() {
		if (eaSupportFlowItemProvider == null) {
			eaSupportFlowItemProvider = new EaSupportFlowItemProvider(this);
		}

		return eaSupportFlowItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.msee.slmtoolbox.modeling.model.lang.eaStar.coreElements.EaControlFlow} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EaControlFlowItemProvider eaControlFlowItemProvider;

	/**
	 * This creates an adapter for a {@link org.msee.slmtoolbox.modeling.model.lang.eaStar.coreElements.EaControlFlow}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createEaControlFlowAdapter() {
		if (eaControlFlowItemProvider == null) {
			eaControlFlowItemProvider = new EaControlFlowItemProvider(this);
		}

		return eaControlFlowItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.msee.slmtoolbox.modeling.model.lang.eaStar.coreElements.EaOrganization} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EaOrganizationItemProvider eaOrganizationItemProvider;

	/**
	 * This creates an adapter for a {@link org.msee.slmtoolbox.modeling.model.lang.eaStar.coreElements.EaOrganization}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createEaOrganizationAdapter() {
		if (eaOrganizationItemProvider == null) {
			eaOrganizationItemProvider = new EaOrganizationItemProvider(this);
		}

		return eaOrganizationItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.msee.slmtoolbox.modeling.model.lang.eaStar.coreElements.EaAtomicExtendedActivity} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EaAtomicExtendedActivityItemProvider eaAtomicExtendedActivityItemProvider;

	/**
	 * This creates an adapter for a {@link org.msee.slmtoolbox.modeling.model.lang.eaStar.coreElements.EaAtomicExtendedActivity}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createEaAtomicExtendedActivityAdapter() {
		if (eaAtomicExtendedActivityItemProvider == null) {
			eaAtomicExtendedActivityItemProvider = new EaAtomicExtendedActivityItemProvider(this);
		}

		return eaAtomicExtendedActivityItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.msee.slmtoolbox.modeling.model.lang.eaStar.coreElements.EaStructuralExtendedActivity} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EaStructuralExtendedActivityItemProvider eaStructuralExtendedActivityItemProvider;

	/**
	 * This creates an adapter for a {@link org.msee.slmtoolbox.modeling.model.lang.eaStar.coreElements.EaStructuralExtendedActivity}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createEaStructuralExtendedActivityAdapter() {
		if (eaStructuralExtendedActivityItemProvider == null) {
			eaStructuralExtendedActivityItemProvider = new EaStructuralExtendedActivityItemProvider(this);
		}

		return eaStructuralExtendedActivityItemProvider;
	}

	/**
	 * This returns the root adapter factory that contains this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComposeableAdapterFactory getRootAdapterFactory() {
		return parentAdapterFactory == null ? this : parentAdapterFactory.getRootAdapterFactory();
	}

	/**
	 * This sets the composed adapter factory that contains this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParentAdapterFactory(ComposedAdapterFactory parentAdapterFactory) {
		this.parentAdapterFactory = parentAdapterFactory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object type) {
		return supportedTypes.contains(type) || super.isFactoryForType(type);
	}

	/**
	 * This implementation substitutes the factory itself as the key for the adapter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter adapt(Notifier notifier, Object type) {
		return super.adapt(notifier, this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object adapt(Object object, Object type) {
		if (isFactoryForType(type)) {
			Object adapter = super.adapt(object, type);
			if (!(type instanceof Class<?>) || (((Class<?>)type).isInstance(adapter))) {
				return adapter;
			}
		}

		return null;
	}

	/**
	 * This adds a listener.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void addListener(INotifyChangedListener notifyChangedListener) {
		changeNotifier.addListener(notifyChangedListener);
	}

	/**
	 * This removes a listener.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void removeListener(INotifyChangedListener notifyChangedListener) {
		changeNotifier.removeListener(notifyChangedListener);
	}

	/**
	 * This delegates to {@link #changeNotifier} and to {@link #parentAdapterFactory}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void fireNotifyChanged(Notification notification) {
		changeNotifier.fireNotifyChanged(notification);

		if (parentAdapterFactory != null) {
			parentAdapterFactory.fireNotifyChanged(notification);
		}
	}

	/**
	 * This disposes all of the item providers created by this factory. 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void dispose() {
		if (eaITResourceItemProvider != null) eaITResourceItemProvider.dispose();
		if (eaHumanResourceItemProvider != null) eaHumanResourceItemProvider.dispose();
		if (eaMaterialResourceItemProvider != null) eaMaterialResourceItemProvider.dispose();
		if (eaOrItemProvider != null) eaOrItemProvider.dispose();
		if (eaAndItemProvider != null) eaAndItemProvider.dispose();
		if (eaDivergingAndItemProvider != null) eaDivergingAndItemProvider.dispose();
		if (eaDivergingOrItemProvider != null) eaDivergingOrItemProvider.dispose();
		if (eaConvergingAndItemProvider != null) eaConvergingAndItemProvider.dispose();
		if (eaConvergingOrItemProvider != null) eaConvergingOrItemProvider.dispose();
		if (eaInternalConnectorItemProvider != null) eaInternalConnectorItemProvider.dispose();
		if (eaExternalConnectorItemProvider != null) eaExternalConnectorItemProvider.dispose();
		if (eaProcessConnectorItemProvider != null) eaProcessConnectorItemProvider.dispose();
		if (eaOutputInputFlowItemProvider != null) eaOutputInputFlowItemProvider.dispose();
		if (eaSupportFlowItemProvider != null) eaSupportFlowItemProvider.dispose();
		if (eaControlFlowItemProvider != null) eaControlFlowItemProvider.dispose();
		if (eaOrganizationItemProvider != null) eaOrganizationItemProvider.dispose();
		if (eaAtomicExtendedActivityItemProvider != null) eaAtomicExtendedActivityItemProvider.dispose();
		if (eaStructuralExtendedActivityItemProvider != null) eaStructuralExtendedActivityItemProvider.dispose();
	}

}
