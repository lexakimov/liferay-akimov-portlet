/**
 * Адаптеры значений атрибутов.
 * <p>
 * Нужны чтобы вывести на страницу значения из полей oldValue или newValue в удобном формате.
 * По умолчанию используется {@link ru.akimov.audit.attribute_adapters.DefaultAttributeValueAdapter}, который
 * выводит значения, как они сохранены в базе в полях oldValue и newValue таблицы entity_field_change.
 * <p>
 * Для создания своего адаптера нужно унаследоваться от класса
 * {@link ru.akimov.audit.attribute_adapters.DefaultAttributeValueAdapter} и переопределить метод
 * {@link ru.akimov.audit.attribute_adapters.DefaultAttributeValueAdapter#getAttributeAdapters()}
 *
 * @author akimov
 * created at 25.01.20 12:03
 */
package ru.akimov.audit.attribute_adapters;
