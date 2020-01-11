package ru.isands.akimov.audit.diff_finders;

import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.ModelHintsUtil;
import ru.isands.akimov.audit.exceptions.EntityFieldChangeDetectorException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Объект для поиска изменившихся аттрибутов двух объектов-сущностей одного класса.
 *
 * @param <T>
 */
public abstract class ModelDifferenceFinder<T extends BaseModel<T>> {

	private Map<String, Object> oldValues = new HashMap<>();
	private Map<String, Object> newValues = new HashMap<>();

	abstract List<String> getWatchOnlyFields();

	//String fieldType = ModelHintsUtil.getType(old.getModelClassName(), attributeName);

	ModelDifferenceFinder(T old, T _new) throws EntityFieldChangeDetectorException {

		checkFieldsExists(old != null ? old : _new);

		Map<String, Object> oldAttributes = (old != null) ? old.getModelAttributes() : null;
		Map<String, Object> newAttributes = (_new != null) ? _new.getModelAttributes() : null;

		Set<String> fieldNames = oldAttributes != null ? oldAttributes.keySet() : newAttributes.keySet();

		for (String attributeName : fieldNames) {
			if (!getWatchOnlyFields().contains(attributeName)) {
				continue;
			}

			Object oldValue = oldAttributes != null ? oldAttributes.get(attributeName) : null;
			Object newValue = newAttributes != null ? newAttributes.get(attributeName) : null;

			if (oldValue == null && newValue == null) {
				continue;
			}

			// was changed
			if ((oldValue == null ^ newValue == null) || !oldValue.equals(newValue)) {
				oldValues.put(attributeName, oldValue);
				newValues.put(attributeName, newValue);
			}
		}
	}

	private void checkFieldsExists(T model) throws EntityFieldChangeDetectorException {
		for (String field : getWatchOnlyFields()) {
			boolean fieldExists = ModelHintsUtil.hasField(model.getModelClassName(), field);
			if (!fieldExists){
				throw new EntityFieldChangeDetectorException("Field '" + field + "' not exists in model " + model.getModelClassName());
			}
		}
	}

	public Map<String, Object> getOldValues() {
		return oldValues;
	}

	public Map<String, Object> getNewValues() {
		return newValues;
	}
}
