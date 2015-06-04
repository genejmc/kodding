package desarrollo2015.rest.client.domain;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name="personasdeGsocial")
public class PersonGsocialList {
	private List<PersonGsocial> data;

	public List<PersonGsocial> getData() {
		return data;
	}

	public void setData(List<PersonGsocial> data) {
		this.data = data;
	}
	
}
