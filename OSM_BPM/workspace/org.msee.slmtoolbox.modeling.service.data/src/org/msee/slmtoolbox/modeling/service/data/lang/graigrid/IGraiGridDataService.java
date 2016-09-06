package org.msee.slmtoolbox.modeling.service.data.lang.graigrid;

import java.util.List;

import org.msee.slmtoolbox.modeling.model.lang.graiGrid.coreElements.GgDecisionCenter;
import org.msee.slmtoolbox.modeling.model.lang.graiGrid.coreElements.GgDecisionFrame;
import org.msee.slmtoolbox.modeling.model.lang.graiGrid.coreElements.GgFunction;
import org.msee.slmtoolbox.modeling.model.lang.graiGrid.coreElements.GgInformationCenter;
import org.msee.slmtoolbox.modeling.model.lang.graiGrid.coreElements.GgInformationFlow;
import org.msee.slmtoolbox.modeling.model.lang.graiGrid.coreElements.GgInformationSource;
import org.msee.slmtoolbox.modeling.model.lang.graiGrid.coreElements.GgLevel;
import org.msee.slmtoolbox.modeling.model.lang.graiGrid.coreElements.GgNode;
import org.msee.slmtoolbox.modeling.model.lang.graiGrid.generalElements.GgGraiGrid;
import org.msee.slmtoolbox.modeling.model.lang.graiGrid.root.GgModel;
import org.msee.slmtoolbox.modeling.model.ssm.bsm.BsmDecision;
import org.msee.slmtoolbox.modeling.service.data.exception.ServiceDataException;

public interface IGraiGridDataService {
	
	/**
	 * Find decision list for a enterprise, function and level
	 * @param graigrid		for research
	 * @param function		for research
	 * @param level			for research
	 * @return a decision list
	 */
	public List<BsmDecision> findDecisionList(GgGraiGrid graigrid, GgFunction function, GgLevel level);
	
	/**
	 * Find information center list for a information source and level
	 * @param informationSource
	 * @param level
	 * @return a information center list
	 */
	public List<GgInformationCenter> findInformationCenterList(GgInformationSource informationSource, GgLevel level);
	
	/**
	 * Find function list not in graigrid, but link to graigrid's enterprise
	 * @param graigird		function not link to graigrid
	 * @return a function list <id, name>
	 */
	public List<GgFunction> findFunctionListNotInGraiGird(GgGraiGrid graigrid);


	/**
	 * Find the grai grid model
	 * @return a grai grid model or null if not exist
	 */
	public GgModel findGgModel();

	/**
	 * Find function for a id
	 * @param id	function id
	 * @return function or null if not exist
	 * @throws ServiceDataException	error from database
	 */
	public GgFunction findFunctionById(String id) throws ServiceDataException;

	/**
	 * Find information source for a id
	 * @param id	information source id
	 * @return information source or null if not exist
	 * @throws ServiceDataException	error from database
	 */
	public GgInformationSource findInformationSourceById(String id) throws ServiceDataException;

	/**
	 * Find information center for a id
	 * @param id	information center id
	 * @return information source or null if not exist
	 * @throws ServiceDataException	error from database
	 */
	public GgInformationCenter findInformationCenterById(String idCenter) throws ServiceDataException;

	/**
	 * Find decision center for a id
	 * @param id	information center id
	 * @return information source or null if not exist
	 * @throws ServiceDataException	error from database
	 */
	public GgDecisionCenter findDecisionCenterById(String idCenter) throws ServiceDataException;

	/**
	 * Find information flow for a source and target
	 * @param source	of information flow
	 * @param target	of information flow
	 * @return information flow  or null if not exist
	 */
	public GgInformationFlow findInformationFlowByNodes(GgNode source, GgNode target);
	
	/**
	 * Find decision frame for a source and target
	 * @param source	of decision frame
	 * @param target	of decision frame
	 * @return decision frame or null if not exist
	 */
	public GgDecisionFrame findDecisionFrameNodes(GgNode source, GgNode target);
}
