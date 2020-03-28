package ru.akimov.service.base;

import ru.akimov.service.AuditEntryLocalServiceUtil;

import java.util.Arrays;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class AuditEntryLocalServiceClpInvoker {
    private String _methodName0;
    private String[] _methodParameterTypes0;
    private String _methodName1;
    private String[] _methodParameterTypes1;
    private String _methodName2;
    private String[] _methodParameterTypes2;
    private String _methodName3;
    private String[] _methodParameterTypes3;
    private String _methodName4;
    private String[] _methodParameterTypes4;
    private String _methodName5;
    private String[] _methodParameterTypes5;
    private String _methodName6;
    private String[] _methodParameterTypes6;
    private String _methodName7;
    private String[] _methodParameterTypes7;
    private String _methodName8;
    private String[] _methodParameterTypes8;
    private String _methodName9;
    private String[] _methodParameterTypes9;
    private String _methodName10;
    private String[] _methodParameterTypes10;
    private String _methodName11;
    private String[] _methodParameterTypes11;
    private String _methodName12;
    private String[] _methodParameterTypes12;
    private String _methodName13;
    private String[] _methodParameterTypes13;
    private String _methodName14;
    private String[] _methodParameterTypes14;
    private String _methodName15;
    private String[] _methodParameterTypes15;
    private String _methodName48;
    private String[] _methodParameterTypes48;
    private String _methodName49;
    private String[] _methodParameterTypes49;
    private String _methodName54;
    private String[] _methodParameterTypes54;
    private String _methodName55;
    private String[] _methodParameterTypes55;
    private String _methodName56;
    private String[] _methodParameterTypes56;
    private String _methodName57;
    private String[] _methodParameterTypes57;
    private String _methodName58;
    private String[] _methodParameterTypes58;

    public AuditEntryLocalServiceClpInvoker() {
        _methodName0 = "addAuditEntry";

        _methodParameterTypes0 = new String[] { "ru.akimov.model.AuditEntry" };

        _methodName1 = "createAuditEntry";

        _methodParameterTypes1 = new String[] { "int" };

        _methodName2 = "deleteAuditEntry";

        _methodParameterTypes2 = new String[] { "int" };

        _methodName3 = "deleteAuditEntry";

        _methodParameterTypes3 = new String[] { "ru.akimov.model.AuditEntry" };

        _methodName4 = "dynamicQuery";

        _methodParameterTypes4 = new String[] {  };

        _methodName5 = "dynamicQuery";

        _methodParameterTypes5 = new String[] {
                "com.liferay.portal.kernel.dao.orm.DynamicQuery"
            };

        _methodName6 = "dynamicQuery";

        _methodParameterTypes6 = new String[] {
                "com.liferay.portal.kernel.dao.orm.DynamicQuery", "int", "int"
            };

        _methodName7 = "dynamicQuery";

        _methodParameterTypes7 = new String[] {
                "com.liferay.portal.kernel.dao.orm.DynamicQuery", "int", "int",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };

        _methodName8 = "dynamicQueryCount";

        _methodParameterTypes8 = new String[] {
                "com.liferay.portal.kernel.dao.orm.DynamicQuery"
            };

        _methodName9 = "dynamicQueryCount";

        _methodParameterTypes9 = new String[] {
                "com.liferay.portal.kernel.dao.orm.DynamicQuery",
                "com.liferay.portal.kernel.dao.orm.Projection"
            };

        _methodName10 = "fetchAuditEntry";

        _methodParameterTypes10 = new String[] { "int" };

        _methodName11 = "getAuditEntry";

        _methodParameterTypes11 = new String[] { "int" };

        _methodName12 = "getPersistedModel";

        _methodParameterTypes12 = new String[] { "java.io.Serializable" };

        _methodName13 = "getAuditEntries";

        _methodParameterTypes13 = new String[] { "int", "int" };

        _methodName14 = "getAuditEntriesCount";

        _methodParameterTypes14 = new String[] {  };

        _methodName15 = "updateAuditEntry";

        _methodParameterTypes15 = new String[] { "ru.akimov.model.AuditEntry" };

        _methodName48 = "getBeanIdentifier";

        _methodParameterTypes48 = new String[] {  };

        _methodName49 = "setBeanIdentifier";

        _methodParameterTypes49 = new String[] { "java.lang.String" };

        _methodName54 = "addAuditEntry";

        _methodParameterTypes54 = new String[] { "ru.akimov.model.AuditEntry" };

        _methodName55 = "updateAuditEntry";

        _methodParameterTypes55 = new String[] { "ru.akimov.model.AuditEntry" };

        _methodName56 = "deleteAuditEntry";

        _methodParameterTypes56 = new String[] { "int" };

        _methodName57 = "deleteAuditEntry";

        _methodParameterTypes57 = new String[] { "ru.akimov.model.AuditEntry" };

        _methodName58 = "deleteFor";

        _methodParameterTypes58 = new String[] { "java.lang.String", "int" };
    }

    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        if (_methodName0.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
            return AuditEntryLocalServiceUtil.addAuditEntry((ru.akimov.model.AuditEntry) arguments[0]);
        }

        if (_methodName1.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
            return AuditEntryLocalServiceUtil.createAuditEntry(((Integer) arguments[0]).intValue());
        }

        if (_methodName2.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
            return AuditEntryLocalServiceUtil.deleteAuditEntry(((Integer) arguments[0]).intValue());
        }

        if (_methodName3.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
            return AuditEntryLocalServiceUtil.deleteAuditEntry((ru.akimov.model.AuditEntry) arguments[0]);
        }

        if (_methodName4.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
            return AuditEntryLocalServiceUtil.dynamicQuery();
        }

        if (_methodName5.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
            return AuditEntryLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0]);
        }

        if (_methodName6.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
            return AuditEntryLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                ((Integer) arguments[1]).intValue(),
                ((Integer) arguments[2]).intValue());
        }

        if (_methodName7.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
            return AuditEntryLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                ((Integer) arguments[1]).intValue(),
                ((Integer) arguments[2]).intValue(),
                (com.liferay.portal.kernel.util.OrderByComparator) arguments[3]);
        }

        if (_methodName8.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
            return AuditEntryLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0]);
        }

        if (_methodName9.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
            return AuditEntryLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                (com.liferay.portal.kernel.dao.orm.Projection) arguments[1]);
        }

        if (_methodName10.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
            return AuditEntryLocalServiceUtil.fetchAuditEntry(((Integer) arguments[0]).intValue());
        }

        if (_methodName11.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
            return AuditEntryLocalServiceUtil.getAuditEntry(((Integer) arguments[0]).intValue());
        }

        if (_methodName12.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
            return AuditEntryLocalServiceUtil.getPersistedModel((java.io.Serializable) arguments[0]);
        }

        if (_methodName13.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
            return AuditEntryLocalServiceUtil.getAuditEntries(((Integer) arguments[0]).intValue(),
                ((Integer) arguments[1]).intValue());
        }

        if (_methodName14.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
            return AuditEntryLocalServiceUtil.getAuditEntriesCount();
        }

        if (_methodName15.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
            return AuditEntryLocalServiceUtil.updateAuditEntry((ru.akimov.model.AuditEntry) arguments[0]);
        }

        if (_methodName48.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes48, parameterTypes)) {
            return AuditEntryLocalServiceUtil.getBeanIdentifier();
        }

        if (_methodName49.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes49, parameterTypes)) {
            AuditEntryLocalServiceUtil.setBeanIdentifier((java.lang.String) arguments[0]);

            return null;
        }

        if (_methodName54.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes54, parameterTypes)) {
            return AuditEntryLocalServiceUtil.addAuditEntry((ru.akimov.model.AuditEntry) arguments[0]);
        }

        if (_methodName55.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes55, parameterTypes)) {
            return AuditEntryLocalServiceUtil.updateAuditEntry((ru.akimov.model.AuditEntry) arguments[0]);
        }

        if (_methodName56.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes56, parameterTypes)) {
            return AuditEntryLocalServiceUtil.deleteAuditEntry(((Integer) arguments[0]).intValue());
        }

        if (_methodName57.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes57, parameterTypes)) {
            return AuditEntryLocalServiceUtil.deleteAuditEntry((ru.akimov.model.AuditEntry) arguments[0]);
        }

        if (_methodName58.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes58, parameterTypes)) {
            AuditEntryLocalServiceUtil.deleteFor((java.lang.String) arguments[0],
                ((Integer) arguments[1]).intValue());

            return null;
        }

        throw new UnsupportedOperationException();
    }
}
