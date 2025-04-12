package extensions

import org.gradle.api.Project
import utils.getLocalProperty
import utils.getSecutrityProperty
import utils.getSigningConfigProperty
import utils.getVersionProperty

/**
 * Obtain property declared on `$projectRoot/local.properties` file.
 *
 * @param propertyName the name of declared property
 */
fun Project.getLocalProperty(propertyName: String): String {
    return getLocalProperty(propertyName, this)
}

/**
 * Obtain property declared on `$projectRoot/security.properties` file.
 *
 * @param propertyName the name of declared property
 */
fun Project.getSecurityProperty(propertyName: String): String {
    return getSecutrityProperty(propertyName, this)
}

/**
 * Obtain property declared on `$projectRoot/version.properties` file.
 *
 * @param propertyName the name of declared property
 */
fun Project.getVersionProperty(propertyName: String): String {
    return getVersionProperty(propertyName, this)
}

/**
 * Obtain property declared on `$projectRoot/signingConfigFile.properties` file.
 *
 * @param propertyName the name of declared property
 */
fun Project.getSigningConfigProperty(propertyName: String): String {
    return getSigningConfigProperty(propertyName, this)
}