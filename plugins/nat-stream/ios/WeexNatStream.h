//
//  WeexNatStream.h
//
//  Created by huangyake on 17/1/7.
//  Copyright © 2017 Instapp. All rights reserved.
//


#import <Foundation/Foundation.h>

#import <WeexSDK/WeexSDK.h>

@protocol WeexNatStreamPro <WXModuleProtocol>
- (void)fetch:(NSDictionary *)params :(WXModuleCallback)callback;
@end

@interface WeexNatStream : NSObject<WeexNatStreamPro>

@end
