//
//  WeexNatVibration.m
//
//  Created by huangyake on 17/1/7.
//  Copyright © 2017 Instapp. All rights reserved.
//


#import "WeexNatVibration.h"
#import "NatVibration.h"

@implementation WeexNatVibration
@synthesize weexInstance;
WX_EXPORT_METHOD(@selector(vibrate::))

- (void)vibrate:(NSNumber *)time :(WXModuleCallback)callback{
    [[NatVibration singletonManger] vibrate:time :^(id error, id result) {
        if (error) {
            if (callback) {
                callback(error);
            }
        }else{
            if (callback) {
                callback(result);
            }
        }
        
    }];
}

@end
