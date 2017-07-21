//
//  WeexNatCommunication.m
//
//  Created by huangyake on 17/1/7.
//  Copyright © 2017 Instapp. All rights reserved.
//

#import "WeexNatCommunication.h"
#import "NatComm.h"


@implementation WeexNatCommunication
@synthesize weexInstance;
WX_EXPORT_METHOD(@selector(call::))
WX_EXPORT_METHOD(@selector(mail:::))
WX_EXPORT_METHOD(@selector(sms:::))


- (void)call:(NSString *)phone :(WXModuleCallback)callback{
    [[NatComm singletonManger] call:phone :^(id error,id result) {
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


- (void)mail:(NSArray *)mail :(NSDictionary*)params :(WXModuleCallback)callback{
    [[NatComm singletonManger] mail:mail :params :^(id error,id result) {
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

- (void)sms:(NSArray *)phone :(NSString *)text :(WXModuleCallback)callback{
    [[NatComm singletonManger] sms:phone :text :^(id error,id result) {
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
