import React from 'react';
import QRCode from 'react-native-qrcode-svg';
import { Centered, Column, Text } from '../../components/ui';
import { Colors } from '../../components/ui/styleUtils';
import { MainRouteProps } from '../../routes/main';
import { ReceiveVcModal } from './ReceiveVcModal';
import { MessageOverlay } from '../../components/MessageOverlay';
import { useRequestScreen } from './RequestScreenController';

export const RequestScreen: React.FC<MainRouteProps> = (props) => {
  const controller = useRequestScreen(props);

  return (
    <Column fill padding="98 24 24 24" backgroundColor={Colors.LightGrey}>
      <Column>
        {controller.isBluetoothDenied ? (
          <Text color={Colors.Red} align="center">
            Please enable Bluetooth to be able to request{' '}
            {controller.vcLabel.singular}
          </Text>
        ) : (
          controller.isWaitingForConnection && (
            <Text align="center">
              Show this QR code to request {controller.vcLabel.singular}
            </Text>
          )
        )}
      </Column>

      <Centered fill>
        {controller.isWaitingForConnection &&
        controller.connectionParams !== '' ? (
          <QRCode
            size={200}
            value={controller.connectionParams}
            backgroundColor={Colors.LightGrey}
          />
        ) : null}
      </Centered>

      {controller.statusMessage !== '' && (
        <Column elevation={1} padding="16 24">
          <Text>{controller.statusMessage}</Text>
        </Column>
      )}

      <ReceiveVcModal
        isVisible={controller.isReviewing}
        onDismiss={controller.REJECT}
        onAccept={controller.ACCEPT}
        onReject={controller.REJECT}
        headerTitle={`Incoming ${controller.vcLabel.singular}`}
      />

      <MessageOverlay
        isVisible={controller.isAccepted}
        title="Success!"
        message={`${controller.vcLabel.singular} has been successfully received from ${controller.senderInfo.deviceName}`}
        onBackdropPress={controller.DISMISS}
      />

      <MessageOverlay
        isVisible={controller.isRejected}
        title="Notice"
        message={`You rejected ${controller.senderInfo.deviceName}'s ${controller.vcLabel.singular}`}
        onBackdropPress={controller.DISMISS}
      />

      <MessageOverlay
        isVisible={controller.isDisconnected}
        title="Disconnected"
        message="The connection was interrupted. Please try again."
        onBackdropPress={controller.DISMISS}
      />
    </Column>
  );
};