//
//  WeexNatScreen.h
//
//  Created by huangyake on 17/1/7.
//  Copyright © 2017 Instapp. All rights reserved.
//

#import <Foundation/Foundation.h>
#import <WeexSDK/WeexSDK.h>


@protocol WeexNatScreenPro <WXModuleProtocol>

- (void)info:(WXModuleCallback)callback;
- (void)getBrightness:(WXModuleCallback)callback;
- (void)setBrightness:(NSNumber *)brightness :(WXModuleCallback)callback;
- (void)getOrientation:(WXModuleCallback)callback;

@end

@interface WeexNatScreen : NSObject<WeexNatScreenPro>

@end
