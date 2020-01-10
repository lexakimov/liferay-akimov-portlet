package ru.isands.akimov.model.impl;

import com.liferay.portal.kernel.exception.SystemException;

import ru.isands.akimov.model.EntityEditingHistory;
import ru.isands.akimov.service.EntityEditingHistoryLocalServiceUtil;

/**
 * The extended model base implementation for the EntityEditingHistory service. Represents a row in the &quot;akimov_entity_editing_history&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link EntityEditingHistoryImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EntityEditingHistoryImpl
 * @see ru.isands.akimov.model.EntityEditingHistory
 * @generated
 */
public abstract class EntityEditingHistoryBaseImpl
    extends EntityEditingHistoryModelImpl implements EntityEditingHistory {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. All methods that expect a entity editing history model instance should use the {@link EntityEditingHistory} interface instead.
     */
    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            EntityEditingHistoryLocalServiceUtil.addEntityEditingHistory(this);
        } else {
            EntityEditingHistoryLocalServiceUtil.updateEntityEditingHistory(this);
        }
    }
}