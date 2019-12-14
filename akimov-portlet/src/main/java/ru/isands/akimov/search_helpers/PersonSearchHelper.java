package ru.isands.akimov.search_helpers;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.SystemException;
import ru.isands.akimov.model.Person;
import ru.isands.akimov.service.PersonLocalServiceUtil;

import java.util.List;

import static com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil.groupProperty;

public class PersonSearchHelper {

	private DynamicQuery buildQuery() {
		DynamicQuery query = PersonLocalServiceUtil.dynamicQuery();

		return query;
	}

	public int getTotal() throws SystemException {
		DynamicQuery query = buildQuery();
		Projection projection = groupProperty("id");
		query.setProjection(projection);

		return (int) PersonLocalServiceUtil.dynamicQueryCount(query);
	}

	@SuppressWarnings("unchecked")
	public List<Person> getResult(int start, int end) throws SystemException {
		DynamicQuery query = buildQuery();

		query.addOrder(OrderFactoryUtil.asc("lastName"));
		query.addOrder(OrderFactoryUtil.asc("firstName"));

		return PersonLocalServiceUtil.dynamicQuery(query, start, end);
	}


}
