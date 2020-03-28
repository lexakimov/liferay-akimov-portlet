package ru.akimov.service.impl;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextThreadLocal;
import com.liferay.portal.util.PortalUtil;
import ru.akimov.model.AuditEntry;
import ru.akimov.model.AuditEntryGroup;
import ru.akimov.model.impl.AuditEntryGroupImpl;
import ru.akimov.service.AuditEntryGroupLocalServiceUtil;
import ru.akimov.service.base.AuditEntryGroupLocalServiceBaseImpl;

import java.util.Date;
import java.util.List;

public class AuditEntryGroupLocalServiceImpl extends AuditEntryGroupLocalServiceBaseImpl {

	private static final Log log = LogFactoryUtil.getLog(AuditEntryGroupLocalServiceImpl.class);

	public AuditEntryGroup create() throws SystemException, PortalException {
		int entryGroupId = (int) CounterLocalServiceUtil.increment(AuditEntryGroup.class.getName());
		AuditEntryGroup entryGroup = AuditEntryGroupLocalServiceUtil.createAuditEntryGroup(entryGroupId);
		populateRequiredDataFromServiceContext(entryGroup);
		return entryGroup;
	}

	private void populateRequiredDataFromServiceContext(AuditEntryGroup auditEntryGroup) throws SystemException, PortalException {
		final ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		boolean isSignedIn = serviceContext.isSignedIn();
		long companyId = serviceContext.getCompanyId();
		User user = PortalUtil.getUser(serviceContext.getRequest());

		auditEntryGroup.setCompanyId(companyId);
		auditEntryGroup.setUserId(isSignedIn ? user.getUserId() : -1);
		auditEntryGroup.setUserName(isSignedIn ? user.getFullName() : "Гость");

		Date eventDate = auditEntryGroup.getEventDate();
		if (eventDate == null) {
			auditEntryGroup.setEventDate(new Date());
		}
	}

	@Override
	public AuditEntryGroup addAuditEntryGroup(AuditEntryGroup auditEntryGroup) throws SystemException {
		List<AuditEntry> entries = ((AuditEntryGroupImpl) auditEntryGroup).entries;
		AuditEntryGroup entryGroup = super.addAuditEntryGroup(auditEntryGroup);
		log.debug(String.format("AUDIT: entry group [%d] persisted in database.", entryGroup.getEntryGroupId()));
		persistEntries(entryGroup, entries);
		return entryGroup;
	}

	@Override
	public AuditEntryGroup updateAuditEntryGroup(AuditEntryGroup auditEntryGroup) throws SystemException {
		List<AuditEntry> entries = ((AuditEntryGroupImpl) auditEntryGroup).entries;
		AuditEntryGroup entryGroup = super.updateAuditEntryGroup(auditEntryGroup);
		log.debug(String.format("AUDIT: entry group [%d] persisted in database.", entryGroup.getEntryGroupId()));
		persistEntries(entryGroup, entries);
		return entryGroup;
	}

	/**
	 * Сохранить группу записей аудита с вложенными в неё записями.
	 */
	private void persistEntries(AuditEntryGroup entryGroup, List<AuditEntry> entries) throws SystemException {

		for (AuditEntry entry : entries) {
			entry.setEntryGroupId(entryGroup.getEntryGroupId());
			entry.persist();
		}
		log.debug(
				String.format("AUDIT: %d entries of group [%d] persisted in database.",
						entries.size(), entryGroup.getEntryGroupId())
		);
	}

}
