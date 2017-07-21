//
//  WeexNatVolume.h
//
//  Created by huangyake on 17/1/7.
//  Copyright © 2017 Instapp. All rights reserved.
//


#import <Foundation/Foundation.h>
#import <WeexSDK/WeexSDK.h>


@protocol WeexNatVolumePro <WXModuleProtocol>

- (void)get:(WXModuleCallback)callback;
- (void)set:(NSNumber *)volume :(WXModuleCallback)callback;

@end

@interface WeexNatVolume : NSObject<WeexNatVolumePro>

@end
