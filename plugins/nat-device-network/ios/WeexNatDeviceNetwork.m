//
//  WeexNatDeviceNetwork.m
//
//  Created by huangyake on 17/1/7.
//  Copyright © 2017 Instapp. All rights reserved.
//


#import "WeexNatDeviceNetwork.h"
#import "NatDeviceNetwork.h"

@implementation WeexNatDeviceNetwork
@synthesize weexInstance;
WX_EXPORT_METHOD(@selector(status:))

- (void)status:(WXModuleCallback)callback{
    [[NatDeviceNetwork singletonManger] status:^(id error, id result) {
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
