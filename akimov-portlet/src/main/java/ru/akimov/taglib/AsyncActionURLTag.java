package ru.akimov.taglib;

import com.liferay.taglib.portlet.ResourceURLTag;
import ru.akimov.constants.URLParams;

import javax.servlet.jsp.JspException;

/**
 * @author akimov
 * created at 01.02.2020 14:04
 */
public class AsyncActionURLTag extends ResourceURLTag {

	private String _asyncActionMethod;

	public void setAsyncActionMethod(String asyncActionMethod) {
		_asyncActionMethod = asyncActionMethod;
	}

	public String getAsyncActionMethod() {
		return _asyncActionMethod;
	}

	@Override
	public int doEndTag() throws JspException {
		setCopyCurrentRenderParameters(false);
		setId(URLParams.ASYNC_ACTION_RESOURCE_ID);
		addParam(URLParams.ASYNC_ACTION_METHOD_PARAM, _asyncActionMethod);

		return super.doEndTag();
	}

}
