//
//  WeexNatCompass.m
//
//  Created by huangyake on 17/1/7.
//  Copyright © 2017 Instapp. All rights reserved.
//


#import "WeexNatCompass.h"
#import "NatCompass.h"

@implementation WeexNatCompass
WX_EXPORT_METHOD(@selector(get:))
WX_EXPORT_METHOD(@selector(watch::))
WX_EXPORT_METHOD(@selector(clearWatch:))

- (void)get:(WXModuleCallback)callback{
    [[NatCompass singletonManger] get:^(id error,id result) {
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
    [[NatCompass singletonManger] watch:options :^(id error,id result) {
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
    [[NatCompass singletonManger] clearWatch:^(id error,id result) {
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
    [[NatCompass singletonManger] close];
}

@end
