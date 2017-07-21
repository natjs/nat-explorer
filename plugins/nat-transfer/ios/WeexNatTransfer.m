//
//  WeexNatTransfer.m
//
//  Created by huangyake on 17/1/7.
//  Copyright © 2017 Instapp. All rights reserved.
//


#import "WeexNatTransfer.h"
#import "NatTransfer.h"

@implementation WeexNatTransfer
WX_EXPORT_METHOD(@selector(download::))
WX_EXPORT_METHOD(@selector(upload::))

- (void)download:(NSDictionary *)params :(WXModuleCallback)callback{
    [[[NatTransfer alloc] init] download:params :^(id error,id result) {
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
- (void)upload:(NSDictionary *)params :(WXModuleCallback)callback{
        [[[NatTransfer alloc] init] upload:params :^(id error,id result) {
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
