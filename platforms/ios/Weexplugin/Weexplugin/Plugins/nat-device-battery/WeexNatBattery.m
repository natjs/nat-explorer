//
//  WeexNatBattery.m
//
//  Created by huangyake on 17/1/7.
//  Copyright © 2017 Instapp. All rights reserved.
//

#import "WeexNatBattery.h"
#import "NatBattery.h"

@implementation WeexNatBattery
@synthesize weexInstance;
WX_EXPORT_METHOD(@selector(status:))

- (void)status:(WXModuleCallback)callback{
    [[NatBattery singletonManger] status:^(id error, id result) {
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
