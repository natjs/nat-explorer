//
//  WeexNatAccelerometer.h
//
//  Created by huangyake on 17/1/7.
//  Copyright © 2017 Instapp. All rights reserved.
//


#import <Foundation/Foundation.h>
#import <WeexSDK/WeexSDK.h>

@protocol WeexNatAccelerometerPro <WXModuleProtocol>

- (void)get:(WXModuleCallback)callback;

- (void)watch:(NSDictionary *)options :(WXKeepAliveCallback)callback;

- (void)clearWatch:(WXModuleCallback)callback;
@end


@interface WeexNatAccelerometer : NSObject<WeexNatAccelerometerPro>

@end
