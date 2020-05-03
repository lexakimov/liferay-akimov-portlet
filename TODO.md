

**Общее** 
    unit testing
    logging

**Диалоги**

**Портлеты**
    асинхронное действие
        с/без перезагрузки элемента
        с/без сообщений
    асинхронное обновление куска страницы
    асинхронная загрузка файлов.
	FileUtil
	TempFileUtil
	крысенко

**Поиск**
    рефакторинг search helpers

**Аудит**
   !!!!! аудит через шину
   транзакция аудита
    аудит - при определенных изменёных полях выводить кастомное сообщение
    метаданные для аудита
    гость?
    
    отловить событие
    
    кто инициатор события
    
    выявить изменения полей
    
    определить его тип
        дефолтный тип, либо по изменёным полям
        от типа зависит описание + к описанию нужны метаданные
            заполнить метаданные
            
    адаптировать изменения полей к базе
        есть дефолтный адаптер.
        
    сохранить в базу

    вывод с адаптацией
        если есть адаптер
        
    _ADDITIONAL_INFO = "additionalInfo";
    _CLASS_NAME = "className";
    _CLASS_PK = "classPK";
    _CLIENT_HOST = "clientHost";
    _CLIENT_IP = "clientIP";
    _COMPANY_ID = "companyId";
    _DATE_FORMAT = "yyyyMMddkkmmssSSS";
    _EVENT_TYPE = "eventType";
    _MESSAGE = "message";
    _SERVER_NAME = "serverName";
    _SERVER_PORT = "serverPort";
    _SESSION_ID = "sessionID";
    _TIMESTAMP = "timestamp";
    _USER_ID = "userId";
    _USER_NAME = "userName";
        
    jsonObj.put(_ADDITIONAL_INFO, _additionalInfo);
    jsonObj.put(_COMPANY_ID, _companyId);
    jsonObj.put(_CLASS_PK, _classPK);
    jsonObj.put(_CLASS_NAME, _className);
    jsonObj.put(_CLIENT_HOST, _clientHost);
    jsonObj.put(_CLIENT_IP, _clientIP);
    jsonObj.put(_MESSAGE, _message);
    jsonObj.put(_SERVER_PORT, _serverPort);
    jsonObj.put(_SERVER_NAME, _serverName);
    jsonObj.put(_SESSION_ID, _sessionID);
    jsonObj.put(_TIMESTAMP, _getDateFormat().format(new Date()));
    jsonObj.put(_EVENT_TYPE, _eventType);
    jsonObj.put(_USER_ID, _userId);
    jsonObj.put(_USER_NAME, _userName);
        
* простое журналирование 
  * (1) создать группу записей
  * (1) создать запись
  * (*) создать изменение аттрибута


* транзакзионное
  * (1) создать группу записей
  * (*) создать запись
  * (**)создать изменение аттрибута
  * коммит


* Группа записей аудита
  * entryGroupId	[pk]
  * companyId		[not zero]
  * userId			[not zero or -1 if guest]
  * userName		[not null or Гость]
  * eventDate		[not null, service watched]


* Запись аудита
  * entryId			[pk]
  * entryGroupId	[reference, not zero]
  * auditType		[not null]
  * entityType		[nullable]
  * entityId		[can be zero]
  * metadata        [json, nullable]


* Изменение атрибута сущности
  * fieldChangeId	[pk]
  * entryId			[reference, not zero]
  * fieldName		[not null]
  * oldValue		[nullable]
  * newValue		[nullable]
