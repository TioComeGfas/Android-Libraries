package cl.tiocomegfas.lib.bluetooth

enum class BluetoothState(
    val id: Int
) {
    STATE_DISCONNECTED(0),
    STATE_CONNECTING(1),
    STATE_CONNECTED(2)
}