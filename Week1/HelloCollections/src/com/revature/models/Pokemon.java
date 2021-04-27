package com.revature.models;

public class Pokemon {

	public String name;
	public String type;
	
	
	
	//constructor so that we can initialize Pokemon objects using "new"
	public Pokemon(String name, String type) {
		super();
		this.name = name;
		this.type = type;
	}

	//toString returns a String representation of the object when we print 
	@Override
	public String toString() {
		return "Pokemon [name=" + name + ", type=" + type + "]";
	}

	//Hashcode will give each instantiated objects a hash value 
	//(a unique value)
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	//Equals will let you compare your objects by hashcode
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pokemon other = (Pokemon) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}
		
	//you can also pull up the menu to auto-generate this stuff via the source tab
	
}
