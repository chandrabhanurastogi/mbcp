package com.ifli.mbcp.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Represents a Meeting task. Basically this will capture the reason/details for
 * customer meeting. Eg. "Initial Meeting"
 * 
 * @author Niranjan
 * @since 20 May 2013
 * @version 1.0
 */
@Entity
@Table(name = "tbl_lookup_task_type")
public class TaskType extends GenericLookup implements Serializable
{
	/**
	 * Unique identifier for the Task type
	 */
	@Override
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "taskTypeId")
	public Long getId()
	{
		return super.getId();
	}

	/**
	 * Name of the Task
	 */
	@Override
	@Column(name = "taskTypeName", length = 50, nullable = false)
	public String getName()
	{
		return super.getName();
	}

	/**
	 * Description or Additional Information about the Task type
	 */
	@Override
	@Column(name = "taskTypeDescription", length = 128, nullable = true)
	public String getDescription()
	{
		return super.getDescription();
	}

	private static final long	serialVersionUID	= 2677991942498741732L;
}
