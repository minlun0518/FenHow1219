package com.lunlun.fenhow1219;

public class DeviceManage {
    private int devicePosition;
    private String deviceImei;
    private int deviceType; //0=公務機,1=個人手機
    private String deviceName;

    public DeviceManage() {
    }

    public DeviceManage(int devicePosition, String deviceImei, int deviceType, String deviceName) {
        this.devicePosition = devicePosition;
        this.deviceImei = deviceImei;
        this.deviceType = deviceType;
        this.deviceName = deviceName;
    }

    public int getDevicePosition() {
        return devicePosition;
    }

    public void setDevicePosition(int devicePosition) {
        this.devicePosition = devicePosition;
    }

    public String getDeviceImei() {
        return deviceImei;
    }

    public void setDeviceImei(String deviceImei) {
        this.deviceImei = deviceImei;
    }

    public int getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(int deviceType) {
        this.deviceType = deviceType;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

}
