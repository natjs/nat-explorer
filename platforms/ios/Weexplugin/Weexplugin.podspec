# coding: utf-8

Pod::Spec.new do |s|
  s.name         = "Weexplugin"
  s.version      = "0.0.1"
  s.summary      = "Weex plugin container"

  s.description  = <<-DESC
                   Weexplugin Source Description
                   DESC

  s.homepage     = "https://github.com/weexteam/weex-pack.git"
  s.license = {
    :type => 'Copyright',
    :text => <<-LICENSE
           Alibaba-INC copyright
    LICENSE
  }
  s.authors      = {
                     "yangshengtao" =>"yangshengtao1314@163.com"
                   }
  s.platform     = :ios
  s.ios.deployment_target = "7.0"

  s.source =  { :path => '.' }
  s.source_files  = "Weexplugin/**/*.{h,m,mm}"
  # s.exclude_files = "Classes/Exclude"
  s.resources = "Weexplugin/Resources/*"
  

  s.requires_arc = true

  #s.xcconfig = { "FRAMEWORK_SEARCH_PATHS" => "$(SDKROOT)/TRemoteDebugger" }
  s.dependency "WeexSDK"
  s.dependency 'NatBattery'
  s.dependency 'NatCommunication'
  s.dependency 'NatModal'
  s.dependency 'NatCamera'
  s.dependency 'NatDeviceInfo'
  s.dependency 'NatDeviceNetwork'
  s.dependency 'NatScreen'
  s.dependency 'NatVibration'
  s.dependency 'NatVolume'
  s.dependency 'NatGeolocation'
  s.dependency 'NatAudio'
  s.dependency 'NatImage'
  s.dependency 'NatVideo'
  s.dependency 'NatRecorder'
  s.dependency 'NatAccelerometer'
  s.dependency 'NatCompass'
  s.dependency 'NatStream'
  s.dependency 'NatTransfer'
  s.dependency 'NatImage', '0.0.6'
  s.dependency 'NatCamera', '0.0.3'
  s.dependency 'NatCamera', '0.0.2'
  s.dependency 'NatModal', '0.0.1'
  s.dependency 'NatCommunication', '0.0.1'
  s.dependency 'NatBattery', '0.0.2'
  s.dependency 'NatDeviceNetwork', '0.0.2'
  s.dependency 'NatDeviceInfo', '0.0.2'
  s.dependency 'NatScreen', '0.0.1'
  s.dependency 'NatVibration', '0.0.1'
  s.dependency 'NatVolume', '0.0.1'
  s.dependency 'NatGeolocation', '0.0.4'
  s.dependency 'NatGeolocation', '0.0.6'
  s.dependency 'NatAudio', '0.0.3'
  s.dependency 'NatImage', '0.0.7'
  s.dependency 'NatVideo', '0.0.3'
  s.dependency 'NatVolume', '0.0.2'
  s.dependency 'NatRecorder', '0.0.1'
  s.dependency 'NatAccelerometer', '0.0.2'
  s.dependency 'NatCompass', '0.0.1'
  s.dependency 'NatStream', '0.0.1'
  s.dependency 'NatTransfer', '0.0.3'
  s.dependency 'NatRecorder', '0.0.2'
  s.dependency 'NatTransfer', '0.0.4'
  #${weexpackPlaceHolder}

  # s.vendored_frameworks = 'Weexplugin.framework'

  # s.user_target_xcconfig  = { 'FRAMEWORK_SEARCH_PATHS' => "'$(PODS_ROOT)/Weexplugin'" }

end
