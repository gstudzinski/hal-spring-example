package org.gst.base;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;

import javax.xml.bind.annotation.XmlElement;
import java.util.HashMap;
import java.util.Map;

public abstract class HALResource extends ResourceSupport {

    private final Map<String, ResourceSupport> embedded = new HashMap<>();

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @XmlElement(name = "embedded", namespace = Link.ATOM_NAMESPACE)
    @JsonProperty("_embedded")
    public Map<String, ResourceSupport> getEmbeddedResources() {
        return embedded;
    }

    public void embedResource(String relationship, ResourceSupport resource) {
        embedded.put(relationship, resource);
    }
}