//
//  WeexNatDeviceInfo.m
//
//  Created by huangyake on 17/1/7.
//  Copyright © 2017 Instapp. All rights reserved.
//

#import "WeexNatDeviceInfo.h"
#import "NatDeviceInfo.h"

@implementation WeexNatDeviceInfo
@synthesize weexInstance;
WX_EXPORT_METHOD(@selector(info:))


- (void)info:(WXModuleCallback)callback{
    [[NatDeviceInfo singletonManger] info:^(id error, id result) {
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
