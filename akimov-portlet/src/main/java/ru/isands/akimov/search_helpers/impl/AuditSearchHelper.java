package ru.isands.akimov.search_helpers.impl;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import ru.isands.akimov.model.EntityEditingHistory;
import ru.isands.akimov.search_helpers.AdaptedDynamicQuerySearchHelper;
import ru.isands.akimov.search_helpers.adapters.AuditEntryAdapter;
import ru.isands.akimov.search_helpers.adapters.PersonEntryAdapter;

import javax.portlet.PortletException;
import java.util.List;

public class AuditSearchHelper extends AdaptedDynamicQuerySearchHelper<AuditEntryAdapter, EntityEditingHistory> {

	public AuditSearchHelper() {
		super(EntityEditingHistory.class);
	}

	@Override
	protected DynamicQuery addOrdering(DynamicQuery query) {
		query.addOrder(OrderFactoryUtil.desc("dateOfChange"));
		return query;
	}

	@Override
	public AuditEntryAdapter adapt(EntityEditingHistory model) throws PortletException {
		return new AuditEntryAdapter(model);
	}

}
