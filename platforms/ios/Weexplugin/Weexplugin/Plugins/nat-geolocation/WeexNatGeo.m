//
//  WeexNatGeo.m
//
//  Created by huangyake on 17/1/7.
//  Copyright © 2017 Instapp. All rights reserved.
//


#import "WeexNatGeo.h"
#import "NatGeolocation.h"

@implementation WeexNatGeo
@synthesize weexInstance;
WX_EXPORT_METHOD(@selector(get:))
WX_EXPORT_METHOD(@selector(watch::))
WX_EXPORT_METHOD(@selector(clearWatch:))


- (void)clearWatch:(WXModuleCallback)callback{
    [[NatGeolocation singletonManger] clearWatch:^(id error,id result) {
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
    [[NatGeolocation singletonManger] watch:options :^(id error,id result) {
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
- (void)get:(WXModuleCallback)callback{
    
    [[NatGeolocation singletonManger] get:^(id error,id result) {
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
    
}

@end
