//
//  WeexNatAccelerometer.m
//
//  Created by huangyake on 17/1/7.
//  Copyright © 2017 Instapp. All rights reserved.
//

#import "WeexNatAccelerometer.h"
#import "NatAccelerometer.h"

@implementation WeexNatAccelerometer
WX_EXPORT_METHOD(@selector(get:))
WX_EXPORT_METHOD(@selector(watch::))
WX_EXPORT_METHOD(@selector(clearWatch:))

- (void)get:(WXModuleCallback)callback{
    [[NatAccelerometer singletonManger] get:^(id error,id result) {
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

- (void)watch:(NSDictionary *)options :(WXKeepAliveCallback)callback{
    [[NatAccelerometer singletonManger] watch:options :^(id error,id result) {
        if (error) {
            if (callback) {
                callback(error,YES);
            }
        }else{
            if (callback) {
                callback(result,YES);
            }
        }

    }];
}

- (void)clearWatch:(WXModuleCallback)callback{
    [[NatAccelerometer singletonManger] clearWatch:^(id error,id result) {
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

- (void)dealloc{
    [[NatAccelerometer singletonManger] close];
}
@end
