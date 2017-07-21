//
//  WeexNatScreen.m
//
//  Created by huangyake on 17/1/7.
//  Copyright © 2017 Instapp. All rights reserved.
//

#import "WeexNatScreen.h"
#import "NatScreen.h"

@implementation WeexNatScreen
@synthesize weexInstance;
WX_EXPORT_METHOD(@selector(info:))
WX_EXPORT_METHOD(@selector(getBrightness:))
WX_EXPORT_METHOD(@selector(setBrightness::))
WX_EXPORT_METHOD(@selector(getOrientation:))


- (void)info:(WXModuleCallback)callback{
    [[NatScreen singletonManger] info:^(id error, id result) {
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
- (void)getBrightness:(WXModuleCallback)callback{
    [[NatScreen singletonManger] getBrightness:^(id error, id result) {
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
- (void)setBrightness:(NSNumber *)brightness :(WXModuleCallback)callback{
    [[NatScreen singletonManger] setBrightness:brightness :^(id error, id result) {
        if (error) {
            callback(error);
        }else{
            callback(result);
        }
    }];
}

- (void)getOrientation:(WXModuleCallback)callback{
    [[NatScreen singletonManger] getOrientation:^(id error, id result) {
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
