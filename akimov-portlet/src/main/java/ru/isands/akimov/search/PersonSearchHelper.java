package ru.isands.akimov.search;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import ru.isands.akimov.model.Person;
import ru.isands.akimov.service.PersonLocalServiceUtil;

import java.util.List;

public class PersonSearchHelper {

	private DynamicQuery buildQuery() {
		DynamicQuery query = PersonLocalServiceUtil.dynamicQuery();
		return query;
	}

	public int getTotal() throws SystemException {
		return (int) PersonLocalServiceUtil.dynamicQueryCount(buildQuery());
	}

	public List<Person> getResult(int start, int end) throws SystemException {
		return PersonLocalServiceUtil.dynamicQuery(buildQuery(), start, end);
	}


}
