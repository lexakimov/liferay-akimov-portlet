## Асинхронная перезагрузка элемента страницы

Добавлена возможность перезагрузки части страницы (без перезагрузки всей страницы целиком).

**Пример реализации**

* в jsp файле: 

```html
    <!--id reloadableElement4 произвольный, нужен чтобы выделить часть страницы как элемент -->
    <div id="reloadableElement4" class="bordered-block-1" style="width: 400px; display: inline-block;">
        <jsp:include page="reloadable_element.jsp"/>
    </div>
    
    <portlet:renderURL var="reloading4URL" windowState="<%=LiferayWindowState.EXCLUSIVE.toString()%>">
        <portlet:param name="mvcPath" value="/jsp/async_actions/reloadable_element.jsp"/>
        <portlet:param name="long_time_render" value="true"/> <!--произвольные параметры не возбраняются-->
    </portlet:renderURL>
    
    <aui:button name="reload4" value="ReloadContent" primary="true"/>
    
    <script>
        $(function () {
            $("button#<portlet:namespace/>reload4").click(function () {
                var reloadableElement = $('div#reloadableElement4');
                reloadElementContentAdvanced(reloadableElement, '${reloading4URL}'); // смотри также reloadElementContent()
            });
        });
    </script>
```

* reloadable_element.jsp - элемент, вынесенный на отдельную jsp.

функции находится в файле async.js. Рекомендую ознакомиться с его содержимым.

при первой загрузке страницы элемент подгружается сразу через тэг ```jsp:include```, 
при этом указанной в теге jsp передаются атрибуты со scope request, и текущие параметры урла. Это надо учитывать.

Есть ещё вариант использовать тэг ```liferay-util:include``` вместо ```jsp:include```. 
О том чем он отличается прочитаете в интернете.