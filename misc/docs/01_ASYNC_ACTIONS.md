## Асинхронные действия

Добавлена возможность совершать асинхронные действия (действия без перезагрузки страницы).

**Пример реализации**

* создать класс портлета, расширяющий ExtendedMVCPortlet
* в классе потлета создать метод обработки действия. Метод пометить аннотацией AsyncActionMethod:

```
	@AsyncActionMethod
	public void methodName(PortletRequest request, PortletResponse response) {
		/* put your code here */
	}
```

* На странице создать resourceURL следующего вида:

```html
    <portlet:resourceURL var="urlName" id="async_action">
        <portlet:param name="async_action_method" value="methodName"/>
        <portlet:param name="customParam1" value="customValue1"/>
        <portlet:param name="customParam2" value="customValue2"/>
        <portlet:param name="customParam3" value="customValue3"/>
    </portlet:resourceURL>
```

или так (с использованием констант для параметров урла)

```html
    <portlet:resourceURL var="urlName" id="<%=ASYNC_ACTION_RESOURCE_ID%>">
        <portlet:param name="<%=ASYNC_ACTION_METHOD_PARAM%>" value="methodName"/>
        <portlet:param name="customParam1" value="customValue1"/>
        <portlet:param name="customParam2" value="customValue2"/>
        <portlet:param name="customParam3" value="customValue3"/>
    </portlet:resourceURL>
```

* вызов действия можно выпльнить через JavaScript:

```javascript
	$(function () {
		var callback = function () {
			console.log('this is callback');
		};

		$("button#<portlet:namespace/>execAction1").click(function () {
			asyncAction('${urlName1}', {messageBox: 'div#messageBox1', callback: callback});
		});
	});
```

функция asyncAction находится в файле async.js. Рекомендую ознакомиться с его содержимым.

К объекту ```PortletRequest request``` передаваемому в ваш асинхронный метод позволительно добавлять информационные сообщения:
Ключи и значения сообщений прописываются в messages_ru.properties.

```
    // сообщение об ошибке:
    SessionErrors.add(request, "error.message.key.1");

    // прочие сообщения
    SessionMessages.add(request, "error.message.key");
    SessionMessages.add(request, "info.message.key");
    SessionMessages.add(request, "success.message.key");
    SessionMessages.add(request, "block.message.key");
    SessionMessages.add(request, "simple.message.key");
```

сообщения, добавленные с помощью ```SessionErrors.add``` будут выведены как ошибки (красный), вне зависимоти от названия ключа.
сообщения, добавленные с помощью ```SessionMessages.add``` будт выведены в зависимости от слова, с котоого начинается название ключа:
success - зелёный
error - красный
block - жёлтый
info - синий
любой другой будет выведен как info