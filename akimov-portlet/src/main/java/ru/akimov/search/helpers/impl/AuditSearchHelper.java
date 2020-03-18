package ru.akimov.search.helpers.impl;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import ru.akimov.model.AuditEntry;
import ru.akimov.search.entry_adapters.impl.AuditSearchEntryAdapter;
import ru.akimov.search.entry_adapters.impl.PersonSearchEntryAdapter;
import ru.akimov.search.helpers.AdaptedDynamicQuerySearchHelper;

import javax.portlet.PortletException;

public class AuditSearchHelper extends AdaptedDynamicQuerySearchHelper<AuditSearchEntryAdapter, AuditEntry> {

	public AuditSearchHelper() {
		super(AuditEntry.class);
	}

	public AuditSearchHelper(SearchContainer<AuditSearchEntryAdapter> container) throws PortletException {
		this();
		container.setResults(this.getAdaptedResult(container.getStart(), container.getEnd()));
		container.setTotal(this.getTotal());
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
