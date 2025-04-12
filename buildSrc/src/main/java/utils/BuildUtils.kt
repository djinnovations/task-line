package utils

import org.gradle.api.Project
import java.util.Properties

private const val LOCAL_PROPERTIES_FILE_NAME = "local.properties"
private const val SECURITY_PROPERTIES_FILE_NAME = "security.properties"
private const val VERSION_PROPERTIES_FILE_NAME = "version.properties"
private const val CONFIG_PROPERTIES_FILE_NAME = "signingConfigFile.properties"

/**
 * Util to obtain property declared on `$projectRoot/local.properties` file.
 *
 * @param propertyName the name of declared property
 * @param project the project reference
 *
 * @return the value of property name, otherwise throw [Exception]
 */
fun getLocalProperty(propertyName: String, project: Project): String {
    val localProperties = Properties().apply {
        val localPropertiesFile = project.rootProject.file(LOCAL_PROPERTIES_FILE_NAME)
        if (localPropertiesFile.exists()) {
            load(localPropertiesFile.inputStream())
        }
    }

    return localProperties.getProperty(propertyName)?.let {
        it
    } ?: run {
        throw NoSuchFieldException("Not defined property: $propertyName")
    }
}

/**
 * Util to obtain property declared on `$projectRoot/security.properties` file.
 *
 * @param propertyName the name of declared property
 * @param project the project reference
 *
 * @return the value of property name, otherwise throw [Exception]
 */
fun getSecutrityProperty(propertyName: String, project: Project): String {
    val localProperties = Properties().apply {
        val localPropertiesFile = project.rootProject.file(SECURITY_PROPERTIES_FILE_NAME)
        if (localPropertiesFile.exists()) {
            load(localPropertiesFile.inputStream())
        }
    }

    return localProperties.getProperty(propertyName)?.let {
        it
    } ?: run {
        throw NoSuchFieldException("Not defined property: $propertyName")
    }
}

/**
 * Util to obtain property declared on `$projectRoot/version.properties` file.
 *
 * @param propertyName the name of declared property
 * @param project the project reference
 *
 * @return the value of property name, otherwise throw [Exception]
 */
fun getVersionProperty(propertyName: String, project: Project): String {
    val localProperties = Properties().apply {
        val localPropertiesFile = project.rootProject.file(VERSION_PROPERTIES_FILE_NAME)
        if (localPropertiesFile.exists()) {
            load(localPropertiesFile.inputStream())
        }
    }

    return localProperties.getProperty(propertyName)?.let {
        it
    } ?: run {
        throw NoSuchFieldException("Not defined property: $propertyName")
    }
}

/**
 * Util to obtain property declared on `$projectRoot/signignConfigFile.properties` file.
 *
 * @param propertyName the name of declared property
 * @param project the project reference
 *
 * @return the value of property name, otherwise throw [Exception]
 */
fun getSigningConfigProperty(propertyName: String, project: Project): String {
    val localProperties = Properties().apply {
        val localPropertiesFile = project.rootProject.file(CONFIG_PROPERTIES_FILE_NAME)
        if (localPropertiesFile.exists()) {
            load(localPropertiesFile.inputStream())
        }
    }

    return localProperties.getProperty(propertyName)?.let {
        it
    } ?: run {
        throw NoSuchFieldException("Not defined property: $propertyName")
    }
}