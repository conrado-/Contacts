package io.github.miguelrf.contacts.model;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;
import org.mongojack.ObjectId;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import com.google.common.collect.Lists;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Contact {

	public static final String NAME = "name";

	@ObjectId
	@JsonProperty("_id")
	private String id;

	@NotNull
	@NotEmpty
	@Pattern(regexp = "[A-Za-zöäüÖÄÜ ]*", message = "must contain only letters and spaces")
	private String name;

	private List<Assignemet> projectDays;

	public Contact() {
		projectDays = Lists.newArrayList();
	}

	public Contact(String name) {
		this.name = name;
		projectDays = Lists.newArrayList();
	}

	public void addProjectDays(Assignemet bonus) {
		projectDays.add(bonus);
	}

	public void addProjectDays(List<Assignemet> bonus) {
		projectDays.addAll(bonus);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public List<Assignemet> getProjectDays() {
		return projectDays;
	}

	public void setProjectDays(List<Assignemet> projectDays) {
		this.projectDays = projectDays;
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(Contact.class).add("id", id)
				.add("name", name).toString();
	}

}
