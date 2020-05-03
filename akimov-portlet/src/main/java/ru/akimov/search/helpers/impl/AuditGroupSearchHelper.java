package ru.akimov.search.helpers.impl;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import ru.akimov.model.AuditEntry;
import ru.akimov.model.AuditEntryGroup;
import ru.akimov.search.entry_adapters.impl.AuditGroupSearchEntryAdapter;
import ru.akimov.search.helpers.AdaptedDynamicQuerySearchHelper;

import javax.portlet.PortletException;

public class AuditGroupSearchHelper extends AdaptedDynamicQuerySearchHelper<AuditGroupSearchEntryAdapter, AuditEntryGroup> {

	public AuditGroupSearchHelper() {
		super(AuditEntryGroup.class);
	}

	public AuditGroupSearchHelper(SearchContainer<AuditGroupSearchEntryAdapter> container) throws PortletException {
		this();
		container.setResults(this.getAdaptedResult(container.getStart(), container.getEnd()));
		container.setTotal(this.getTotal());
	}

	@Override
	protected DynamicQuery addOrdering(DynamicQuery query) {
		query.addOrder(OrderFactoryUtil.desc("eventDate"));
		return query;
	}

	@Override
	public AuditGroupSearchEntryAdapter adapt(AuditEntryGroup model) throws PortletException {
		return new AuditGroupSearchEntryAdapter(model);
	}

}
