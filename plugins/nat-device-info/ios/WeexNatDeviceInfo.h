//
//  WeexNatDeviceInfo.h
//
//  Created by huangyake on 17/1/7.
//  Copyright © 2017 Instapp. All rights reserved.
//

#import <Foundation/Foundation.h>
#import <WeexSDK/WeexSDK.h>


@protocol WeexNatDeviceInfoPro <WXModuleProtocol>

- (void)info:(WXModuleCallback)callback;

@end

@interface WeexNatDeviceInfo : NSObject<WeexNatDeviceInfoPro>

@end
