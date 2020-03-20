package ru.akimov.functional;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import java.io.IOException;

/**
 * @author akimov
 * created at 13.02.2020 17:53
 */
@FunctionalInterface
public interface ResourceActionMethod {
	void execute(ResourceRequest request, ResourceResponse response) throws IOException, PortletException;
}