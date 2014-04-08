IOS-SDK
=======

���������� SDK ��������� � ����� PAYU_SDK.
��� ���������� PAYU ������ ���������� ����� � ���� ������.

�������� �������. ��� ������ �������� ����������, ����� �����.

1. ALU - ����� ��� ������ � ���������� Automatic Live Update
2. LU - ����� ��� ������ � ���������� Live Update
3. IRN - ����� ��� ������ � ���������� Instant Refund Notification
4. IDN - ����� ��� ������ � ���������� Instant Delivery Notification
5. IOS - ����� ��� �������� ������� �������

��������� �������� ���� ������� � ����� ������� ����� ����� � �������� �������.

�������� ������� ������ �� ������� ALU (Automatic Live Update)

1. ��������� ������ � �������� ���� ��� ����������� ��� ������.

    NSMutableDictionary *orderDetails = [NSMutableDictionary new];
    [orderDetails setValue:@"2014-04-01 19:30:57" forKey:@"ORDER_DATE"];
    [orderDetails setValue:@"Android" forKey:@"MERCHANT"];
    [orderDetails setValue:@"3886786" forKey:@"ORDER_REF"];
    [orderDetails setValue:@"CCVISAMC" forKey:@"PAY_METHOD"];
    [orderDetails setValue:@"" forKey:@"BACK_REF"];
    [orderDetails setValue:@"RU" forKey:@"LANGUAGE"];
    [orderDetails setValue:@"RUB" forKey:@"PRICES_CURRENCY"];

2.   ������ ������������� ������� ALU � ������ ��������� ����
   
      ALU *alu = [[ALU alloc] initWithSecretKey:@"8~Z4?t6[c~_o4)8=R4p2"];

3.  ���������� ��������� ����� � ������ #1 � ������� ���������
    [alu sendALURequest:orderDetails withResult:^(NSData *response, NSError *error) {
        //��������� �������
        if (response) {
            NSString *result = [[NSString alloc] initWithData:response encoding:NSUTF8StringEncoding];
           
            UIAlertView *alert = [[UIAlertView alloc] initWithTitle:nil message:result delegate:nil cancelButtonTitle:@"OK" otherButtonTitles:nil];
            [alert show];
           
            NSLog(@"%@",result);
        }
        else{
            UIAlertView *alert = [[UIAlertView alloc] initWithTitle:nil message:error.localizedDescription delegate:nil cancelButtonTitle:@"OK" otherButtonTitles:nil];
            [alert show];
           
            NSLog(@"%@",error);
        }
    }];
