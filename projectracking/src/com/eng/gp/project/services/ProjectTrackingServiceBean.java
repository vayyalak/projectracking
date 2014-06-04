package com.eng.gp.project.services;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import org.apache.log4j.Logger;

import com.eng.gp.project.domain.ProjectTrackingItem;
import com.eng.gp.project.domain.ProjectType;
import com.eng.gp.project.domain.exception.InvalidPremisesException;
import com.eng.gp.project.domain.exception.InvalidProjectCreationException;
import com.eng.gp.project.domain.exception.InvalidProjectException;
import com.eng.gp.project.domain.exception.InvalidProjectTypeException;
import com.eng.gp.project.entity.PremisesEntity;
import com.eng.gp.project.entity.ProjectTrackingItemEntity;
import com.eng.gp.project.entity.ProjectTypeEntity;
import com.eng.gp.project.impl.JPAPremisesManager;
import com.eng.gp.project.impl.JPAProjectTrackingItemManager;
import com.eng.gp.project.impl.JPAProjectTypeManager;
import com.eng.gp.project.managers.PremisesManager;
import com.eng.gp.project.managers.ProjectTrackingItemManager;
import com.eng.gp.project.managers.ProjectTypeManager;
import com.eng.gp.project.util.DateFormats;
import com.eng.gp.project.util.date.TimeZones;
import com.gridpoint.energy.util.DateFormatter;
import com.gridpoint.energy.util.NotNull;
import com.gridpoint.energy.util.date.LocalDateTime;


public class ProjectTrackingServiceBean implements  ProjectTrackingService {

	private static final Logger log = Logger.getLogger(ProjectTrackingServiceBean.class);

	ProjectTypeManager projectTypeManager;
	PremisesManager premisesManager;
	ProjectTrackingItemManager projectTrackingItemManager;



	public void saveProject (ProjectTrackingItem projectTracking) throws Exception {

		ProjectTrackingItemEntity entity = new ProjectTrackingItemEntity();

		if(projectTracking.getProjectName()==null || projectTracking.getProjectName().contains(" ") || projectTracking.getProjectName().isEmpty()){
			throw new Exception("ProjectName cannot be null");
		}

		if(projectTracking.getProjectTypeId()!=null){
			projectTypeManager =new JPAProjectTypeManager();
			ProjectTypeEntity projectTypeEntity = projectTypeManager.findByPrimaryKey(projectTracking.getProjectTypeId());
			if(projectTypeEntity==null){
				throw new Exception("ProjectName cannot be null");
			}
			entity.setProjectType(projectTypeEntity);
		}else{
			throw new Exception("Project Type cannot be null");
		}

		if(projectTracking.getPremisesId()!=null){
			premisesManager = new JPAPremisesManager();
			PremisesEntity premisesEntity = premisesManager.findByPrimaryKey(projectTracking.getPremisesId());
			if(premisesEntity==null){
				throw new Exception("Invalid Premises");
			}
			entity.setPremises(premisesEntity);
		} else{
			throw new Exception("Premises ID cannot be null");
		}
		entity.setProjectName(projectTracking.getProjectName());
		entity.setChannels(projectTracking.getChannels());
		entity.setStartDate(projectTracking.getStartDate());
		entity.setEndDate(projectTracking.getEndDate());

		projectTrackingItemManager = new JPAProjectTrackingItemManager();
		projectTrackingItemManager.persist(entity);

		log.debug("Save success");

	}
	
	
	
	public ProjectTrackingItem updateProject(ProjectTrackingItem projectTracking) throws InvalidProjectException, InvalidProjectCreationException,InvalidPremisesException, InvalidProjectTypeException {
		
		projectTrackingItemManager = new JPAProjectTrackingItemManager();
			ProjectTrackingItemEntity entity = null;
			if (projectTracking.getProjectId() != null) {
				entity = projectTrackingItemManager.findByPrimaryKey(projectTracking.getProjectId());
			}else{
				throw new InvalidProjectException("Project Id can not be null");
			}
			ProjectTrackingItemEntity projectEntity = null;
			if (entity != null) {
				if(projectTracking.getProjectName()==null || projectTracking.getProjectName().contains(" ") || projectTracking.getProjectName().isEmpty() ){
					throw new InvalidProjectCreationException("ProjectName cannot be null");
				}
				
				if(projectTracking.getProjectTypeId()!=null){
					ProjectTypeEntity projectTypeEntity = projectTypeManager
							.findByPrimaryKey(projectTracking.getProjectTypeId());
					if(projectTypeEntity==null){
						throw new InvalidProjectTypeException(projectTracking.getProjectTypeId());
					}
					entity.setProjectType(projectTypeEntity);
				}else{
					throw new InvalidProjectCreationException("Project Type cannot be null");
				}
				
				if(projectTracking.getPremisesId()!=null){
					PremisesEntity premisesEntity = premisesManager
							.findByPrimaryKey(projectTracking.getPremisesId());
					if(premisesEntity==null){
						throw new InvalidPremisesException(projectTracking.getPremisesId());
					}
					entity.setPremises(premisesEntity);
				} else{
					throw new InvalidProjectCreationException("Premises ID cannot be null");
				}
				entity.setProjectName(projectTracking.getProjectName());
				entity.setStartDate(projectTracking.getStartDate());
				entity.setEndDate(projectTracking.getEndDate());
				entity.setDeprecated(projectTracking.deprecated());
			} else {
				throw new InvalidProjectException(projectTracking.getProjectId());
			}
			projectEntity = projectTrackingItemManager.upDateProject(entity);
			ProjectTrackingItem projectItem = fromEntity(projectEntity);
			log.debug("Merge success");
			if (projectEntity != null)
				return projectItem;
			else
				return null;
 }
	

	@Override
	public List<ProjectTrackingItem> getAllProjects() {
		projectTrackingItemManager = new JPAProjectTrackingItemManager();
		List<ProjectTrackingItemEntity> projects = projectTrackingItemManager.getAllProjects();
		List<ProjectTrackingItem> projectItemList = new ArrayList<ProjectTrackingItem>();
		for(ProjectTrackingItemEntity projectEntity: projects){
			if(!projectEntity.deprecated()){
				projectItemList.add(fromEntity(projectEntity));
			}
		}
		return projectItemList;
		
	}
	
	
	public ProjectTrackingItem getProjectByProjectId(Long projectId) throws InvalidProjectException {
		NotNull.verify(projectId, "projectId");
		ProjectTrackingItemEntity project = projectTrackingItemManager.findByPrimaryKey(projectId);
		if(project==null){
			throw new InvalidProjectException(projectId);
		}
		if(!project.deprecated()){
			return  (fromEntity(project));
		}else{
			throw new InvalidProjectException("This Project Is Deprecated:"+project.getProjectId());
		}
	}

	@Override
	public int removeAllProjects() {
		int reults =0;
		projectTrackingItemManager = new JPAProjectTrackingItemManager();
		reults = projectTrackingItemManager.removeAllProjects();
		return reults;
	}
	
	@Override
	public List<ProjectType> getAllProjectTypes() {
		List<ProjectType> projectTypeList = null;
		projectTrackingItemManager = new JPAProjectTrackingItemManager();
		projectTypeList = projectTrackingItemManager.getAllProjectTypes();
		return projectTypeList;
	}
	

	public boolean deleteProject(Long projectId) throws InvalidProjectException{
		NotNull.verify(projectId, "projectId");
		projectTrackingItemManager = new JPAProjectTrackingItemManager();
		ProjectTrackingItemEntity entity = projectTrackingItemManager.findByPrimaryKey(projectId);
		boolean result ;
		if(entity!=null){
			result = projectTrackingItemManager.removeById(projectId);
		}else{
			throw new InvalidProjectException(projectId);
		}
		log.debug("Delete success");
		return result;
	}

	private ProjectTrackingItem fromEntity(ProjectTrackingItemEntity projectEntity) {
		if (projectEntity == null) {
			return null;
		} 
		try{
			PremisesEntity premises = projectEntity.getPremises();
			TimeZone tz = TimeZone.getTimeZone(premises.getTimezone());
			Calendar today = Calendar.getInstance();
			LocalDateTime today_utc = new LocalDateTime(today.getTimeInMillis(),TimeZones.UTC);
			LocalDateTime premisesLocaldate = new LocalDateTime(today_utc.instantInUtc(), tz);
			Date siteDate = DateFormatter.parse(DateFormats.DATE_FORMAT_PROJECT_SERVICE_DATE,premisesLocaldate.toString());

			Date dbStartDate = null;
			Date dbEndDate = null;
			LocalDateTime startDate = null;
			LocalDateTime endDate = null;

			if(projectEntity.getStartDate()!=null){
				dbStartDate = projectEntity.getStartDate();
			}
			if(projectEntity.getEndDate()!=null){
				dbEndDate = projectEntity.getEndDate();
			}

			ProjectTrackingItem project = new ProjectTrackingItem();
			if (dbStartDate != null) {

				startDate = new LocalDateTime(dbStartDate.getTime(), tz);
				//startDate = startDate.valueOf(startDate.toString().substring(0, startDate.toString().indexOf(" ")));
				dbStartDate = DateFormatter.parse(DateFormats.DATE_FORMAT_PROJECT_SERVICE_DATE,startDate.toString());
				if (dbEndDate != null) {
					endDate = new LocalDateTime(dbEndDate.getTime(), tz);
					//endDate = endDate.valueOf(endDate.toString().substring(0, endDate.toString().indexOf(" ")));
					dbEndDate =  DateFormatter.parse(DateFormats.DATE_FORMAT_PROJECT_SERVICE_DATE,endDate.toString());
				}
				
				int startDiff =0;
				int endDiff =0;
				
				if(startDate!=null)startDiff = startDate.compareTo(premisesLocaldate);
				if(endDate!=null)endDiff = endDate.compareTo(premisesLocaldate);

				if (dbStartDate.after(siteDate)) {
					project.setProjectStatus("PLANNED");
				} else if ((dbStartDate.before(siteDate) || dbStartDate.equals(siteDate))
						&& (dbEndDate == null || dbEndDate.after(siteDate) || dbEndDate.equals(siteDate))) {
					project.setProjectStatus("PROGRESS");
				} else if (dbEndDate != null && dbEndDate.before(siteDate)) {
					project.setProjectStatus("COMPLETED");
				}

				if(startDiff>0){
					project.setProjectStatus("PLANNED");
				} else if((startDiff<0 || startDiff == 0) && (endDiff>0 || endDiff == 0 )){
					project.setProjectStatus("PROGRESS");
				} else if(endDiff<0){
					project.setProjectStatus("COMPLETED");
				}
			} else{
				project.setProjectStatus("PENDING");
			}

			project.setProjectName(projectEntity.getProjectName());
			project.setProjectId(projectEntity.getProjectId());
			if(dbStartDate!=null)project.setStartDate(dbStartDate);
			if(dbEndDate!=null)project.setEndDate(dbEndDate);
			project.setChannels(projectEntity.getChannels());
			project.setPremisesId(projectEntity.getPremises().getPremisesId());
			project.setProjectTypeId(projectEntity.getProjectType().getProjectTypeId());

			return project;
		}catch(Exception exception){
			exception.printStackTrace();
		}
		return null;
	}

	


}
