//
//  WeexNatModal.h
//
//  Created by huangyake on 17/1/7.
//  Copyright © 2017 Instapp. All rights reserved.
//

#import <Foundation/Foundation.h>
#import <WeexSDK/WeexSDK.h>


@protocol NatModalPro <WXModuleProtocol>

- (void)alert:(NSDictionary *)params :(WXModuleCallback)callback;
- (void)confirm:(NSDictionary *)params :(WXModuleCallback)callback;
- (void)prompt:(NSDictionary *)params :(WXModuleCallback)callback;
- (void)toast:(NSDictionary *)params :(WXModuleCallback)callback;


@end

@interface WeexNatModal : NSObject<NatModalPro>

@end
