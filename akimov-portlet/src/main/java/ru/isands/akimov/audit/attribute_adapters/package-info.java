/**
 * Адаптеры значений атрибутов.
 * Нужны чтобы вывести значения из полей oldValue или newValue в удобном формате.
 * По умолчанию используется {@link ru.isands.akimov.audit.attribute_adapters.DefaultAttributeConverter}, который
 * выводит значения как они сохранены в базе.
 * Для создания своего адаптера нужно унаследоваться от класса
 * {@link ru.isands.akimov.audit.attribute_adapters.DefaultAttributeConverter} и переопределить метод
 * {@link ru.isands.akimov.audit.attribute_adapters.DefaultAttributeConverter#getAttributeAdapters()}
 *
 * @author akimov
 * created at 25.01.20 12:03
 */
package ru.isands.akimov.audit.attribute_adapters;
