package core.java.concept.hashcode;

public class MutableKey {
 private String name;

public MutableKey(String name) {
	super();
	this.name = name;
}

public String getName() {
	return name;
}

@Override
public String toString() {
	return "MutableKey [name=" + name + "]";
}

public MutableKey() {
	super();
}

public void setName(String name) {
	this.name = name;
}
}
