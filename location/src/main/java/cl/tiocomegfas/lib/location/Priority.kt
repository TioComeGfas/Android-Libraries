package cl.tiocomegfas.lib.location

enum class Priority(
    internal val value: Int
) {
    /**
     * Use this setting to request location precision to within a city block, which is an accuracy of approximately 100 meters.
     * This is considered a coarse level of accuracy, and is likely to consume less power. With this setting, the location services
     * are likely to use WiFi and cell tower positioning. Note, however, that the choice of location provider depends on many other
     * factors, such as which sources are available.
     */
    BALANCED_POWER_ACCURACY(102),

    /**
     * Use this setting to request the most precise location possible. With this setting, the
     * location services are more likely to use GPS to determine the location.
     */
    HIGH_ACCURACY(100),

    /**
     * Use this setting to request city-level precision, which is an accuracy of approximately
     * 10 kilometers. This is considered a coarse level of accuracy, and is likely to consume less power.
     */
    LOW_POWER(104),

    /**
     * Use this setting if you need negligible impact on power consumption, but want to receive
     * location updates when available. With this setting, your app does not trigger any location
     * updates, but receives locations triggered by other apps.
     */
    NO_POWER(105)
}