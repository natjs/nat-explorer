//
//  WeexNatBattery.h
//
//  Created by huangyake on 17/1/7.
//  Copyright © 2017 Instapp. All rights reserved.
//


#import <Foundation/Foundation.h>
#import <WeexSDK/WeexSDK.h>


@protocol WeexNatBatteryPro <WXModuleProtocol>

- (void)status:(WXModuleCallback)callback;
@end

@interface WeexNatBattery : NSObject<WeexNatBatteryPro>

@end
