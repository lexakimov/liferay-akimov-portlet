package ru.isands.akimov.search.helpers.impl;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import ru.isands.akimov.model.AuditEntry;
import ru.isands.akimov.search.helpers.AdaptedDynamicQuerySearchHelper;
import ru.isands.akimov.search.entry_adapters.impl.AuditSearchEntryAdapter;

import javax.portlet.PortletException;

public class AuditSearchHelper extends AdaptedDynamicQuerySearchHelper<AuditSearchEntryAdapter, AuditEntry> {

	public AuditSearchHelper() {
		super(AuditEntry.class);
	}

	@Override
	protected DynamicQuery addOrdering(DynamicQuery query) {
		query.addOrder(OrderFactoryUtil.desc("dateOfChange"));
		return query;
	}

	@Override
	public AuditSearchEntryAdapter adapt(AuditEntry model) throws PortletException {
		return new AuditSearchEntryAdapter(model);
	}

}
